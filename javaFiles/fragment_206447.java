public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View myView = new MyView(this);
        setContentView(myView);

        myView.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float x = event.getX();
                float y = event.getY();

                //if(x==... your code here

                invalidate(); //this repaints the view
                return false;
            }
        });
    }
}