public class abc extends Activity implements OnTouchListener 
{
     ImageView img;
     protected void onCreate(Bundle savedInstanceState) 
     {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one);

                img = (ImageView) findViewById(R.id.imageView1);
                img.setOnTouchListener(this);
     }

        public boolean onTouch(View v, MotionEvent event) 
    {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
            {       
                  // Here u can write code which is executed after the user touch on the screen 
                     break; 
            }
            case MotionEvent.ACTION_UP:
            {             
                   // Here u can write code which is executed after the user release the touch on the screen    
                 break;
            }
            case MotionEvent.ACTION_MOVE:
            {  
               // Here u can write code which is executed when user move the finger on the screen   
                break;
            }
        }
        return true;
    }