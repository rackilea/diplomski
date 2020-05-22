import static marvin.MarvinPluginCollection.boundaryFill;
import static marvin.MarvinPluginCollection.floodfillSegmentation;
import static marvin.MarvinPluginCollection.invertColors;
import static marvin.MarvinPluginCollection.moravec;
import static marvin.MarvinPluginCollection.scale;

import java.awt.Color;
import java.awt.Point;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import marvin.image.MarvinImage;
import marvin.image.MarvinSegment;
import marvin.io.MarvinImageIO;

public class ShapesExample {

    private FileWriter fw = null;

    public ShapesExample() throws IOException{
        fw = new FileWriter("out.txt");

        // Scale down the image since the desired features can be extracted
        // in a lower resolution.
        MarvinImage image = MarvinImageIO.loadImage("./res/square.png");
        scale(image.clone(), image, 400);

        // Transform the square in a solid shape
        boundaryFill(image.clone(), image, 1, 1, Color.BLACK);
        invertColors(image);

        MarvinImageIO.saveImage(image, "./res/square_2.png");

        // segment each object
        MarvinSegment[] objs = floodfillSegmentation(image);
        MarvinSegment seg;  

        OUT("Number of objects: " + (objs.length-1));

        int MATRIX_SIZE = 5;
        // For each object...
        // Skip position 0 which is just the background
        for(int i=1; i<objs.length; i++){
            seg = objs[i];

            int[][] output = moravec(image, null, MATRIX_SIZE, 1000);
            List<Point> vertices = getVertices(output, 10);

            // Draw the vertices and print coordinates
            for(Point p:vertices) {
                image.fillRect(p.x-(MATRIX_SIZE/2), p.y-(MATRIX_SIZE/2), 5, 5, Color.red); 
                OUT("Vertex: ("+p.x+","+p.y+")");
             }
        }

        MarvinImageIO.saveImage(image, "./res/square_out.png");
        fw.close();
    }

    private List<Point> getVertices(int[][] cornernessMap, int minDistanceBetweenPoints){
        int corners=0;
        List<Point> points = new ArrayList<Point>();
        for(int x=0; x<cornernessMap.length; x++){
            for(int y=0; y<cornernessMap[0].length; y++){
                // Is it a corner?
                if(cornernessMap[x][y] > 0){
                    // This part of the algorithm avoid inexistent corners
                    // detected almost in the same position due to noise.
                    Point newPoint = new Point(x,y);
                    if(points.size() == 0){
                        points.add(newPoint); corners++;
                    }else {
                        boolean valid=true;
                        for(Point p:points){
                            if(newPoint.distance(p) < minDistanceBetweenPoints){
                                valid=false;
                            }
                        }
                        if(valid){
                            points.add(newPoint); corners++;
                        }
                    }
                }
            }
        }
        return points;
    }

    private void OUTNONL(String str) throws IOException {
        System.out.print(str);
    }

    private void OUT(String str) throws IOException {
        System.out.println(str);
    }

    public static void main(String[] args) throws IOException {
        new ShapesExample();
    }
}