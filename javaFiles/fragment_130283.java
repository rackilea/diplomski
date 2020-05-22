public class MainActivity extends AppCompatActivity implements View.OnTouchListener
{
    PointF center;
    center.x=500;center.y=500;
    float radius[]={100,200,300,400,500};
    DrawOrbit orbit;
    int startX=0,startY=0,currentX=0,currentY=0;
    Handler handler1 = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout layout=(RelativeLayout)findViewById(R.id.scrollableSpace);
        for (int a = 0; a<radius.length ;a++)
        {
            final int index=a;
            handler1.postDelayed(new Runnable() {

                @Override
                public void run() {
                    orbit.draw(center,radius,index);
                }
            }, 300 * a);
        }

        layout.setOnTouchListener(this);
    }   


    @Override
    public boolean onTouch(View v, MotionEvent motionEvent)
    {

        final int action= motionEvent.getAction();
        switch(action & MotionEvent.ACTION_MASK)
        {
            case MotionEvent.ACTION_DOWN:
            {              
                startX=(int)motionEvent.getRawX();
                startY=(int)motionEvent.getRawY();             

                break;
            }
            case MotionEvent.ACTION_MOVE:
            {
                currentX=(int)motionEvent.getRawX();
                currentY=(int)motionEvent.getRawY();               

                float diffX=currentX-startX;
                float diffY=currentY-startY;

                startX=currentX;
                startY=currentY;

                center.x+=diffX;
                center.y+=diffY;

                break;
            } 
            case MotionEvent.ACTION_UP:
            {
                for (int a = 0; a<radius.length ;a++)
                {
                    final int index=a;
                    handler1.postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            orbit.draw(center,radius,index);
                        }
                    }, 300 * a);
                }
                break;
            }

        }
        return true;

    }
}