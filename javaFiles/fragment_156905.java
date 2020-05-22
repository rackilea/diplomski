import acm.program.*;
import acm.graphics.*;

public class Pyramid extends GraphicsProgram
{
    public void run()
    {
        // We calculate some values in order to center the pyramid vertically
        int pyramidHeight = BRICKS_IN_BASE * BRICK_HEIGHT;
        double pyramidY = (getHeight() - pyramidHeight) / 2;

        // For each brick layer...
        for (int i=BRICKS_IN_BASE ; i >= 1; i--)
        {
            // We calculate some values in order to center the layer horizontally
            int layerWidth = BRICKWIDTH * i;
            double layerX = (getWidth() - layerWidth) / 2;
            double layerY = pyramidY + (i-1) * BRICK_HEIGHT;

            // For each brick in the layer...
            for(int j=0 ; j<i ; j++)
            {
                GRect square = new GRect(layerX + j*BRICK_WIDTH, layerY, BRICK_WIDTH, BRICK_HEIGHT);
                add(square);
            }
        }
    }

    private static final int BRICK_WIDTH = 50;
    private static final int BRICK_HEIGHT = 25;
    private static final int BRICKS_IN_BASE = 12;
}