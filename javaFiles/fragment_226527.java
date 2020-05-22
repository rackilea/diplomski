package hashmaptest;

import hashmaptest.HashMapTest.Result;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.imageio.ImageIO;

public class ResultVisualizer {

    private static final Map<Integer, Map<Integer, Set<Result>>> sampleSizeToHashLimit = 
        new HashMap<Integer, Map<Integer, Set<Result>>>();

    private static final DecimalFormat df = new DecimalFormat("0.00");

    static void visualizeResults(final List<Result> results) throws IOException {

        final File tempFolder = new File("C:\\temp");
        final File baseFolder = makeFolder(tempFolder, "hashmap_tests");

        long bestPutTime = -1L;
        long worstPutTime = 0L;
        long bestGetTime = -1L;
        long worstGetTime = 0L;

        for(final Result result : results) {

            final Integer sampleSize = result.sampleSize;
            final Integer hashLimit = result.hashLimit;
            final long putTime = result.averagePutTime;
            final long getTime = result.averageGetTime;

            if(bestPutTime == -1L || putTime < bestPutTime)
                bestPutTime = putTime;
            if(bestGetTime <= -1.0f || getTime < bestGetTime)
                bestGetTime = getTime;

            if(putTime > worstPutTime)
                worstPutTime = putTime;
            if(getTime > worstGetTime)
                worstGetTime = getTime;

            Map<Integer, Set<Result>> hashLimitToResults = 
                sampleSizeToHashLimit.get(sampleSize);
            if(hashLimitToResults == null) {
                hashLimitToResults = new HashMap<Integer, Set<Result>>();
                sampleSizeToHashLimit.put(sampleSize, hashLimitToResults);
            }
            Set<Result> resultSet = hashLimitToResults.get(hashLimit);
            if(resultSet == null) {
                resultSet = new HashSet<Result>();
                hashLimitToResults.put(hashLimit, resultSet);
            }
            resultSet.add(result);

        }

        System.out.println("Best average put time: " + bestPutTime + " ns");
        System.out.println("Best average get time: " + bestGetTime + " ns");
        System.out.println("Worst average put time: " + worstPutTime + " ns");
        System.out.println("Worst average get time: " + worstGetTime + " ns");

        for(final Integer sampleSize : sampleSizeToHashLimit.keySet()) {

            final File sizeFolder = makeFolder(baseFolder, "sample_size_" + sampleSize);

            final Map<Integer, Set<Result>> hashLimitToResults = 
                sampleSizeToHashLimit.get(sampleSize);

            for(final Integer hashLimit : hashLimitToResults.keySet()) {

                final File limitFolder = makeFolder(sizeFolder, "hash_limit_" + hashLimit);

                final Set<Result> resultSet = hashLimitToResults.get(hashLimit);

                final Set<Float> loadFactorSet = new HashSet<Float>();
                final Set<Integer> initialCapacitySet = new HashSet<Integer>();

                for(final Result result : resultSet) {
                    loadFactorSet.add(result.loadFactor);
                    initialCapacitySet.add(result.initialCapacity);
                }

                final List<Float> loadFactors = new ArrayList<Float>(loadFactorSet);
                final List<Integer> initialCapacities = new ArrayList<Integer>(initialCapacitySet);

                Collections.sort(loadFactors);
                Collections.sort(initialCapacities);

                final BufferedImage putImage = 
                    renderMap(resultSet, loadFactors, initialCapacities, worstPutTime, bestPutTime, false);
                final BufferedImage getImage = 
                    renderMap(resultSet, loadFactors, initialCapacities, worstGetTime, bestGetTime, true);

                final String putFileName = "size_" + sampleSize + "_hlimit_" + hashLimit + "_puts.png";
                final String getFileName = "size_" + sampleSize + "_hlimit_" + hashLimit + "_gets.png";

                writeImage(putImage, limitFolder, putFileName);
                writeImage(getImage, limitFolder, getFileName);

            }

        }

    }

    private static File makeFolder(final File parent, final String folder) throws IOException {

        final File child = new File(parent, folder);

        if(!child.exists())
            child.mkdir();

        return child;

    }

    private static BufferedImage renderMap(final Set<Result> results, final List<Float> loadFactors,
            final List<Integer> initialCapacities, final float worst, final float best,
            final boolean get) {

        //[x][y] => x is mapped to initial capacity, y is mapped to load factor
        final Color[][] map = new Color[initialCapacities.size()][loadFactors.size()];

        for(final Result result : results) {
            final int x = initialCapacities.indexOf(result.initialCapacity);
            final int y = loadFactors.indexOf(result.loadFactor);
            final float time = get ? result.averageGetTime : result.averagePutTime;
            final float score = (time - best)/(worst - best);
            final Color c = new Color(score, 1.0f - score, 0.0f);
            map[x][y] = c;
        }

        final int imageWidth = initialCapacities.size() * 40 + 50;
        final int imageHeight = loadFactors.size() * 40 + 50;

        final BufferedImage image = 
            new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_3BYTE_BGR);

        final Graphics2D g = image.createGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, imageWidth, imageHeight);

        for(int x = 0; x < map.length; ++x) {

            for(int y = 0; y < map[x].length; ++y) {

                g.setColor(map[x][y]);
                g.fillRect(50 + x*40, imageHeight - 50 - (y+1)*40, 40, 40);

                g.setColor(Color.BLACK);
                g.drawLine(25, imageHeight - 50 - (y+1)*40, 50, imageHeight - 50 - (y+1)*40);

                final Float loadFactor = loadFactors.get(y);
                g.drawString(df.format(loadFactor), 10, imageHeight - 65 - (y)*40);

            }

            g.setColor(Color.BLACK);
            g.drawLine(50 + (x+1)*40, imageHeight - 50, 50 + (x+1)*40, imageHeight - 15);

            final int initialCapacity = initialCapacities.get(x);
            g.drawString(((initialCapacity%1000 == 0) ? "" + (initialCapacity/1000) + "K" : "" + initialCapacity), 15 + (x+1)*40, imageHeight - 25);
        }

        g.drawLine(25, imageHeight - 50, imageWidth, imageHeight - 50);
        g.drawLine(50, 0, 50, imageHeight - 25);

        g.dispose();

        return image;

    }

    private static void writeImage(final BufferedImage image, final File folder, 
            final String filename) throws IOException {

        final File imageFile = new File(folder, filename);

        ImageIO.write(image, "png", imageFile);

    }

}