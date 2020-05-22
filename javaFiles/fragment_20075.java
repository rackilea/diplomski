public class MainActivity extends Activity implements ColorPickerDialog.OnColorChangedListener {

DrawingView dv ;
RelativeLayout rl;   
    private Paint       mPaint;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    dv = new DrawingView(this);
    setContentView(R.layout.activity_main);
    mPaint = new Paint();
    mPaint.setAntiAlias(true);
    mPaint.setDither(true);
    mPaint.setColor(Color.GREEN);
    mPaint.setStyle(Paint.Style.STROKE);
    mPaint.setStrokeJoin(Paint.Join.ROUND);
    mPaint.setStrokeCap(Paint.Cap.ROUND);
    mPaint.setStrokeWidth(12);
    rl = (RelativeLayout) findViewById(R.id.rl);
    rl.addView(dv);
    Button b = (Button) findViewById(R.id.button1);
    //b.setText(R.string.France);
    Button b1 = (Button) findViewById(R.id.button2);
    rl.setDrawingCacheEnabled(true);
    b.setOnClickListener(new OnClickListener()
    {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
              // dv.clear();    
             new ColorPickerDialog(MainActivity.this, MainActivity.this, mPaint.getColor()).show();


        }

    });

    b1.setOnClickListener(new OnClickListener()
    {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            dv.clear();


        }

    });

}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.activity_main, menu);
    return true;
}

 public class DrawingView extends View {

        private int width;
        private  int height;
        private Bitmap  mBitmap;
        private Canvas  mCanvas;
        private Path    mPath;
        private Paint   mBitmapPaint;
        Context context;
        private Paint circlePaint;
        private Path circlePath;

        public DrawingView(Context c) {
        super(c);
        context=c;
        mPath = new Path();
        mBitmapPaint = new Paint(Paint.DITHER_FLAG);  
         circlePaint = new Paint();
         circlePath = new Path();
         circlePaint.setAntiAlias(true);
         circlePaint.setColor(Color.BLUE);
         circlePaint.setStyle(Paint.Style.STROKE);
         circlePaint.setStrokeJoin(Paint.Join.MITER);
         circlePaint.setStrokeWidth(4f); 


        }

        @Override
         protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width =w;
        height =h;
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);

        }
        public void clear()
        {
            mBitmap = Bitmap.createBitmap(width,height ,
                    Bitmap.Config.ARGB_8888);

                //Log.d("BITMAP","Restoring...");
                //mBitmap=BitmapFactory.decodeByteArray(bytes, 0, bytes.length); 

            mCanvas = new Canvas(mBitmap);

            mPath = new Path();
            mBitmapPaint = new Paint(Paint.DITHER_FLAG);

            //Added later..
            mPaint = new Paint();
            mPaint.setAntiAlias(true);
            mPaint.setDither(true);
            mPaint.setColor(Color.GREEN);
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeJoin(Paint.Join.ROUND);
            mPaint.setStrokeCap(Paint.Cap.ROUND);
            mPaint.setStrokeWidth(12);
            invalidate();
        }
        @Override
        protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);

        canvas.drawPath(mPath, mPaint);

        canvas.drawPath(circlePath, circlePaint);
        }

        private float mX, mY;
        private static final float TOUCH_TOLERANCE = 4;

        private void touch_start(float x, float y) {
        mPath.reset();
        mPath.moveTo(x, y);
        mX = x;
        mY = y;
        }
        private void touch_move(float x, float y) {
        float dx = Math.abs(x - mX);
        float dy = Math.abs(y - mY);
        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
            mPath.quadTo(mX, mY, (x + mX)/2, (y + mY)/2);
            mX = x;
            mY = y;

             circlePath.reset();
             circlePath.addCircle(mX, mY, 30, Path.Direction.CW); 
            // invalidate();

        }
        }
        private void touch_up() {
        mPath.lineTo(mX, mY);
        circlePath.reset();
        // commit the path to our offscreen
        mCanvas.drawPath(mPath, mPaint);
        // kill this so we don't double draw
        mPath.reset();
       // mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SCREEN));//.Mode.SCREEN));
        mPaint.setMaskFilter(null); 
        mCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.SCREEN); 

        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touch_start(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                touch_move(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                touch_up();
                invalidate();
                break;
        }
        return true;
        }  
        }
@Override
public void colorChanged(int color) {
    // TODO Auto-generated method stub
    mPaint.setColor(color);
} 
 }