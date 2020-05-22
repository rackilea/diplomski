import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;

public class Maze {
    private RectF drawRect = new RectF();

    private Bitmap[] bitmaps;
    private int[][] tileType;

    private float screenWidth, screenHeight;

    /**
     * Initialize a new maze.
     * @param wallBitmap The desired bitmaps for the floors and walls
     * @param isWall The wall data array. Each true value in the array represents a wall and each false represents a gap
     * @param xCellCountOnScreen How many cells are visible on the screen on the x axis
     * @param yCellCountOnScreen How many cells are visible on the screen on the y axis
     * @param screenWidth The screen width
     * @param screenHeight The screen height
     */
    public Maze(Bitmap[] bitmaps, int[][] tileType, float xCellCountOnScreen, float yCellCountOnScreen, float screenWidth, float screenHeight){
        this.bitmaps = bitmaps;
        this.tileType = tileType;

        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        drawRect.set(0, 0, screenWidth / xCellCountOnScreen, screenHeight / yCellCountOnScreen);
    }

    /**
     * Get the type of the cell. x and y values are not coordinates!
     * @param x The x index of the cell
     * @param y The y index of the cell
     * @return The cell type
     */
    public int getType(int x, int y){
        if(y < tileType.length && x < tileType[y].length) return tileType[y][x];
        return 0;
    }

    public float getCellWidth(){ return drawRect.width(); }
    public float getCellHeight(){ return drawRect.height(); }

    /**
     * Draws the maze. View coordinates should have positive values.
     * @param canvas Canvas for the drawing
     * @param viewX The x coordinate of the view
     * @param viewY The y coordinate of the view
     */
    public void drawMaze(Canvas canvas, float viewX, float viewY){
        int tileX = 0;
        int tileY = 0;
        float xCoord = -viewX;
        float yCoord = -viewY;

        while(tileY < tileType.length && yCoord <= screenHeight){
            // Begin drawing a new column
            tileX = 0;
            xCoord = -viewX;

            while(tileX < tileType[tileY].length && xCoord <= screenWidth){
                // Check if the tile is not null
                if(bitmaps[tileType[tileY][tileX]] != null){

                    // This tile is not null, so check if it has to be drawn
                    if(xCoord + drawRect.width() >= 0 && yCoord + drawRect.height() >= 0){

                        // The tile actually visible to the user, so draw it
                        drawRect.offsetTo(xCoord, yCoord); // Move the rectangle to the coordinates
                        canvas.drawBitmap(bitmaps[tileType[tileY][tileX]], null, drawRect, null);
                    }
                }

                // Move to the next tile on the X axis
                tileX++;
                xCoord += drawRect.width();
            }

            // Move to the next tile on the Y axis
            tileY++;
            yCoord += drawRect.height();
        }
    }
}