import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class JigsawComplexityTest {
    private static final int defaultHorizontalCount = 40;
    private static final int defaultVerticalCount = 25;

    public static void main(String[] args) throws Exception {
        String test1 = "http://www.ulillillia.us/images/mgscreen.png";
        String test2 = "http://www.ulillillia.us/images/easyjigsawpuzzleimage.png";
        String test3 = "http://www.ulillillia.us/images/hardjigsawpuzzleimage.jpg";
        String test4 = "http://students.cec.wustl.edu/~billchang/cse559/project2/result9.jpg";
        String mostlyGreen = "http://keera.co.uk/blog/wp-content/uploads/2014/08/Screenshot_2014-07-27-22-26-23.png";
        String grass = "http://p1.pichost.me/i/75/2000933.jpg";
        String flowerFields = "http://p1.pichost.me/i/14/1371715.jpg";
        String people = "http://captital-connection.com/wp-content/uploads/2014/10/capitalconnectionpeople.jpg";
        String nature = "http://static.hdw.eweb4.com/media/wallpapers_1920x1200/nature/1/4/pond-between-the-flowers-nature-hd-wallpaper-1920x1200-32983.jpg";
        String puzzle1 = "http://jigsawpuzzlesforadults.com/wp-content/uploads/2013/11/5000-Piece-Jigsaw-Puzzle-Needle-Mountains.png";
        String puzzle2 = "http://jigsawpuzzlesforadults.com/wp-content/uploads/2013/11/18000-Piece-Jigsaw-Puzzle-Paraadise-Sunset.png";
        String puzzle3 = "http://jigsawpuzzlesforadults.com/wp-content/uploads/2013/11/5000-Piece-jigsaw-puzzle-PuzzleRavensburger-Views-of-Modern-Rome-.png";
        String puzzle4 = "http://jigsawpuzzlesforadults.com/wp-content/uploads/2013/11/5000-Piece-Puzzle-James-Rizzi_-City-.png";
        System.out.println("Test1: " + getComplexity(test1));
        System.out.println("Test2: " + getComplexity(test2));
        System.out.println("Test3: " + getComplexity(test3));
        System.out.println("Test4: " + getComplexity(test4));
        System.out.println("Mostrly green: " + getComplexity(mostlyGreen));
        System.out.println("Grass: " + getComplexity(grass));
        System.out.println("Flower fields: " + getComplexity(flowerFields));
        System.out.println("Nature: " + getComplexity(nature));
        System.out.println("People: " + getComplexity(people));
        System.out.println("Puzzle1: " + getComplexity(puzzle1));
        System.out.println("Puzzle2: " + getComplexity(puzzle2));
        System.out.println("Puzzle3: " + getComplexity(puzzle3));
        System.out.println("Puzzle4: " + getComplexity(puzzle4));
    }

    public static double getComplexity(String url) throws IOException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedImage img = ImageIO.read(is);
            return getComplexity(img, defaultHorizontalCount, defaultVerticalCount);
        } finally {
            is.close();
        }
    }

    public static double getComplexity(BufferedImage img, int xCount, int yCount) {
        int w = img.getWidth();
        int h = img.getHeight();
        Color[][] pixels = new Color[h][w];
        for (int y = 0; y < h; y++)
            for (int x = 0; x < w; x++)
                pixels[y][x] = new Color(img.getRGB(x, y));
        int pw = w / xCount;
        int ph = h / yCount;
        pixels = blur(pixels, pw / 5, ph / 5);
        double sumCompl = 0;
        int denominator = 0;
        for (int i = 0; i < xCount; i++)
            for (int j = 0; j < yCount; j++)
                for (int n = i; n < xCount; n++)
                    for (int m = j; m < yCount; m++) {
                        if (i == n && j == m)
                            continue;
                        sumCompl += compareSubimages(pixels, i * pw, j * ph, n * pw, m * ph, pw, ph);
                        denominator++;
                    }
        return sumCompl / denominator;
    }

    private static Color[][] blur(Color[][] input, int dx, int dy) {
        if (dx < 2)
            dx = 2;
        if (dy < 2)
            dy = 2;
        Color[][] ret = new Color[input.length][input[0].length];
        for (int y = 0; y < input.length; y++)
            for (int x = 0; x < input[y].length; x++) {
                int r = 0;
                int g = 0;
                int b = 0;
                int denominator = 0;
                for (int i = -dx; i <= dx; i++) {
                    if (x + i < 0 || x + i >= input[y].length)
                        continue;
                    for (int j = -dy; j <= dy; j++) {
                        if (y + j < 0 || y + j >= input.length)
                            continue;
                        Color c = input[y + j][x + i];
                        r += c.getRed();
                        g += c.getGreen();
                        b += c.getBlue();
                        denominator++;
                    }
                }
                ret[y][x] = new Color(r / denominator, g / denominator, b / denominator);
            }
        return ret;
    }

    private static double compareSubimages(Color[][] pixels, int x1, int y1, 
            int x2, int y2, int pw, int ph) {
        double ret = 0;
        for (int i = 0; i < pw; i++)
            for (int j = 0; j < ph; j++) {
                Color c1 = pixels[y1 + j][x1 + i];
                Color c2 = pixels[y2 + j][x2 + i];
                ret += Math.max(Math.max(Math.abs(c1.getRed() - c2.getRed()) / 255.0, 
                        Math.abs(c1.getGreen() - c2.getGreen()) / 255.0),
                        Math.abs(c1.getBlue() - c2.getBlue()) / 255.0);
            }
        return 1.0 - ret / (pw * ph);
    }
}