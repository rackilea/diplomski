public class MainActivity extends AppCompatActivity 
{
   //Layout
   private RelativeLayout myLayout = null;

   //Screen Size
   private int screenWidth;
   private int screenHeight;

   //Position
   private float ballDownY;
   private float ballDownX;

   //Initialize Class
   private Handler handler = new Handler();
   private Timer timer = new Timer();

   //Images
   private ImageView net = null;
   private ImageView ball = null;

   //score
   private TextView score = null;

   //for net movement along x-axis
   public float x = 0;
   public float y = 0;

   //points
   private int points = 0;


   @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
         super.onCreate(savedInstanceState);

         this.setContentView(R.layout.activity_main);
         this.myLayout = (RelativeLayout) findViewById(R.id.myLayout);

         this.score = (TextView) findViewById(R.id.score);

         this.net = (ImageView) findViewById(R.id.net);
         this.ball = (ImageView) findViewById(R.id.ball);

         //retrieving screen size
         WindowManager wm = getWindowManager();
         Display disp = wm.getDefaultDisplay();
         Point size = new Point();
         disp.getSize(size);
         screenWidth = size.x;
         screenHeight = size.y;

         //move to out of screen
         this.ball.setX(-80.0f);
         this.ball.setY(screenHeight + 80.0f);

          //Error here
         /*//Run constantly
         new Handler().postDelayed(new Runnable()
         {
           @Override
           public void run()
           {
              Render();
           }
         }, 100); //100 is miliseconds interval than sleep this process, 1000 miliseconds is 1 second*/

     Thread t = new Thread() {
     @Override
     public void run() {
     try {
        while (!isInterrupted()) {
             Thread.sleep(100);
             runOnUiThread(new Runnable() {
             @Override
             public void run(){Render();}});}
             }catch (InterruptedException e) {}}};

     t.start();

    }

    public void Render()
    {
        changePos();
        if(Collision(net, ball))
        {
          points++; //You dont need findView Textview score for that exists in OnCreate Method
          this.score.setText("Score:" + points);
        }
    }

    public void changePos() 
    {

        //down
        ballDownY += 10;
        if (ball.getY() > screenHeight) {
        ballDownX = (float) Math.floor((Math.random() * (screenWidth - ball.getWidth())));
        ballDownY = -100.0f;

    }
    ball.setY(ballDownY);
    ball.setX(ballDownX);

      //make net follow finger
      myLayout.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent event) {
            x = event.getX();
            y = event.getY();

            if (event.getAction() == MotionEvent.ACTION_MOVE) {
                net.setX(x);
                net.setY(y);
            }
            return true;
        }

    });

    public boolean Collision(ImageView net, ImageView ball)
    {
       Rect BallRect = new Rect();
       ball.getHitRect(BallRect);
       Rect NetRect = new Rect();
       net.getHitRect(NetRect);
       return BallRect.intersect(NetRect);
    }
}