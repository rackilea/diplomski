import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

/**
 * @author Nicholas Dunn
 * @date 4/21/12
 */
public class CircleGridCreator {

    /**
     *
     * @param radius
     * @return 2 dimensional array in row major order, where entry is 0 if not part
     * of circle, or 1 otherwise
     */
    public static int[][] getGrid(int radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Invalid radius " + radius);
        }

        BufferedImage buffer = new BufferedImage(radius*2, radius*2, BufferedImage.TYPE_INT_RGB);
        Color c = Color.BLUE;
        Graphics2D context = buffer.createGraphics();
        context.setColor(c);
        context.fillOval(0, 0, radius * 2, radius * 2);

        int[][] results = new int[radius*2][radius*2];
        for (int row = 0; row < radius*2; row++) {
            for (int col = 0; col < radius*2; col++) {
                if (buffer.getRGB(col, row) == c.getRGB()) {
                    results[row][col] = 1;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {

            int[][] grid = getGrid(i);

            for (int[] row : grid) {
                System.out.println(Arrays.toString(row));
            }
        }
    }

}