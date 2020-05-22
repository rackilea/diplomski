public class MyGameView extends View implements OnTouchListener{

    static int x, y;
    final static int radius = 25;
    private int androidX;
    private int androidY;
    Paint paint;
    Bitmap android;
    boolean touch = false;

    private Runnable r2 = new Runnable() {

        @Override
        public void run() {
            androidX = (int) Math.ceil(Math.random() * (MyGameView.this.getWidth()-android.getWidth()));
            androidY = (int) Math.ceil(Math.random() * (MyGameView.this.getHeight()-android.getHeight()));
        }
    };

    public MyGameView(Context context) {
        super(context);
        paint = new Paint();
        paint.setAntiAlias(true); // smooth rendering
        android = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        setFocusable(true);
        setOnTouchListener(this);

        new Thread(r2).start(); // run r2 in a separate thread
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(touch == true){
            paint.setARGB(255, 222, 78, 112);
            canvas.drawBitmap(android, androidX, androidY, null);
            canvas.drawCircle(x,y,radius,paint);
        }        
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        x=(int)event.getX()-(radius/2);      
        y=(int)event.getY()-(radius/2);
        switch(event.getAction()){
        case MotionEvent.ACTION_DOWN:
                touch = true;
                break;
        case MotionEvent.ACTION_UP:
                touch = false;
                break;
        }
        return true;
    }
}