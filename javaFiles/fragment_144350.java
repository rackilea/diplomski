public class StartActivity extends Activity {
    private LinearLayout container;   
    private int currentX;   
    private int currentY; 

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        container = (LinearLayout) findViewById(R.id.Container);
        container.scrollTo(220, 400);
    }

    @Override  
    public boolean onTouchEvent(MotionEvent event) { 
      switch (event.getAction()) { 
          case MotionEvent.ACTION_DOWN: { 
              currentX = (int) event.getRawX(); 
              currentY = (int) event.getRawY(); 
              break; 
          } 

          case MotionEvent.ACTION_MOVE: { 
              int x2 = (int) event.getRawX(); 
              int y2 = (int) event.getRawY(); 
              container.scrollBy(currentX - x2 , currentY - y2); 
              currentX = x2; 
              currentY = y2; 
              break; 
          }    
          case MotionEvent.ACTION_UP: { 
              break; 
          } 
      } 
        return true;  
    } 
}