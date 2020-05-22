public class Board extends View
{
    Paint pBack = new Paint();
    Paint pDot = new Paint();
    Paint pLine = new Paint();

    int cols = 5; 
    int rows = 6;

    // Default initialization = false
    boolean[][] dots = new boolean[cols][rows];     

    int canWidth = 0;
    int canHeight = 0;

    float xStep = 0;
    float yStep = 0;

    float[] xCoords = new float[cols];
    float[] yCoords = new float[rows];

    public Board(Context context)
    {
        super(context); 
        pBack.setARGB(255, 255, 102, 0);
        pDot.setARGB(255, 255, 255, 255);

        pLine.setStrokeWidth(5);
        pLine.setARGB(255, 90, 10, 0);
    }

    public void setDots(boolean[][] dotSelected)
    {
        this.dots = dotSelected;
    }

    public boolean[][] getDots()
    {
        return dots;
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        canWidth = w;
        canHeight = h;

        xStep = canWidth / (cols + 1);
        yStep = canHeight / (rows + 1);

        for (int y = 0; y < rows; y++)
        {
            yCoords[y] = (y + 1) * yStep;
        }

        for (int x = 0; x < cols; x++)
        {
            xCoords[x] = (x + 1) * xStep;
        }           
    }

    protected void onDraw(Canvas canvas) 
    {
        super.onDraw(canvas);
        canvas.drawPaint(pBack);

        // Grid, lines and box markings
        for (int y = 0; y < rows; y++)
        {
            canvas.drawLine(xStep, yCoords[y], cols * xStep, yCoords[y], pDot);

            for (int x = 0; x < cols; x++)
            {
                if (y == 0)
                {
                    canvas.drawLine(xCoords[x], yStep, xCoords[x], rows * yStep, pDot);
                }

                if (dots[x][y])
                {
                    boolean left = x > 0 && dots[x - 1][y];
                    boolean up = y > 0 && dots[x][y - 1];

                    if (left)
                    {
                        canvas.drawLine(xCoords[x], yCoords[y], xCoords[x - 1], yCoords[y], pLine);
                    }

                    if (up)
                    {
                        canvas.drawLine(xCoords[x], yCoords[y], xCoords[x], yCoords[y - 1], pLine);
                    }

                    if (left && up && dots[x - 1][y - 1])
                    {
                        canvas.drawCircle(xCoords[x] - xStep / 2, yCoords[y] - yStep / 2, 10, pLine);
                    }
                }
            }
        }

        // Dots
        for (int y = 0; y < rows; y++)
        {
            for (int x = 0; x < cols; x++)
            {
                canvas.drawCircle(xCoords[x], yCoords[y], 20, pDot);                    
                if (dots[x][y])
                {
                    canvas.drawCircle(xCoords[x], yCoords[y], 15, pBack);                       
                }                                       
            }
        }
    }

    public boolean onTouchEvent(MotionEvent event)
    {
        super.onTouchEvent(event);

        if (event.getAction() != MotionEvent.ACTION_DOWN)
            return true;

        int xNear = 0;
        int yNear = 0;

        float xMin = canWidth;
        float yMin = canHeight;

        for (int x = 0; x < cols; x++)
        {
            if (Math.abs(xCoords[x] - event.getX()) < xMin)
            {
                xMin = Math.abs(xCoords[x] - event.getX());
                xNear = x;
            }
        }

        for (int y = 0; y < rows; y++)
        {
            if (Math.abs(yCoords[y] - event.getY()) < yMin)
            {
                yMin = Math.abs(yCoords[y] - event.getY());
                yNear = y;
            }
        }

        dots[xNear][yNear] = !dots[xNear][yNear];
        invalidate();

        return true;
    }
}