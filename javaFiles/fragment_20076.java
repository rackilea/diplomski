public class DrawingManager {

private static DrawingManager mInstance=null;

public DrawingTools mDrawingUtilities=null;

public int mThemeIndex;

    public Canvas  mCanvas;


    public Path    mPath;

    public Paint   mBitmapPaint;

    public Bitmap  mBitmap;

    public Paint  mPaint; 

private DrawingManager()
{

    resetDrawingTools();
}

public static DrawingManager getInstance()
{
    if(mInstance==null)
    {
        mInstance=new DrawingManager();         
    }

    return mInstance;
}


public void resetDrawingTools()
{

    mBitmap = Bitmap.createBitmap(screenwidth,screenheight ,
            Bitmap.Config.ARGB_8888)

    mCanvas = new Canvas(mBitmap);

    Path = new Path();
    mBitmapPaint = new Paint(Paint.DITHER_FLAG);

    //Added later..
    mPaint = new Paint();
    mPaint.setAntiAlias(true);
    mPaint.setDither(true);
    mPaint.setColor(Color.Green);
    mPaint.setStyle(Paint.Style.STROKE);
    mPaint.setStrokeJoin(Paint.Join.ROUND);
    mPaint.setStrokeCap(Paint.Cap.ROUND);
    mPaint.setStrokeWidth(12);


}

/**
 * Clears the drawing board.
 */
public static void clearDrawingBoard()
{
    mInstance=null;
}



public void resetBitmapCanvasAndPath() {
    // TODO Auto-generated method stub
    mBitmap = Bitmap.createBitmap(screenwidth,screenheight ,
            Bitmap.Config.ARGB_8888);

        //Log.d("BITMAP","Restoring...");
        //mBitmap=BitmapFactory.decodeByteArray(bytes, 0, bytes.length); 

    mCanvas = new Canvas(.mBitmap);

    mPath = new Path();
}
}