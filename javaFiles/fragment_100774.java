public class MainActivity extends Activity implements ColorPickerDialog.OnColorChangedListener {

DrawingView dv ;
RelativeLayout rl;   
private Paint       mPaint;
private MaskFilter  mEmboss;
private MaskFilter  mBlur;

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
            AlertDialog.Builder editalert = new AlertDialog.Builder(MainActivity.this);
            editalert.setTitle("Please Enter the name with which you want to Save");
            final EditText input = new EditText(MainActivity.this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.FILL_PARENT,
                    LinearLayout.LayoutParams.FILL_PARENT);
            input.setLayoutParams(lp);
            editalert.setView(input);
            editalert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    rl.setDrawingCacheEnabled(true);
                    String name= input.getText().toString();
                    Bitmap bitmap =rl.getDrawingCache();
                    String root = Environment.getExternalStorageDirectory().toString();
                    File myDir = new File(root + "/MyDraw");    
                    myDir.mkdirs();
                    File file = new File (myDir, name+".png");
                    if (file.exists ()) file.delete ();         
                    try 
                    {
                        if(!file.exists())
                    {
                        file.createNewFile();
                    }
                        FileOutputStream ostream = new FileOutputStream(file);
                        bitmap.compress(CompressFormat.PNG, 10, ostream);
                       // System.out.println("saving......................................................"+path);
                        ostream.close();
                        rl.invalidate();                            
                    } 
                    catch (Exception e) 
                    {
                        e.printStackTrace();
                    }finally
                    {

                       rl.setDrawingCacheEnabled(false);                            
                    }
                }
            });
            editalert.show();   
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

        private static final float MINP = 0.25f;
        private static final float MAXP = 0.75f;
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
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);

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
             invalidate();

        }
        }
        private void touch_up() {
        mPath.lineTo(mX, mY);
        circlePath.reset();
        // commit the path to our offscreen
        mCanvas.drawPath(mPath, mPaint);
        // kill this so we don't double draw
        mPath.reset();

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