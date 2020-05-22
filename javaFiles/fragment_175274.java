public class MotionActivity extends AppCompatActivity {

    private int primaryPointerId   = -1;
    private int secondaryPointerId = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(new FrameLayout(this));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        int action = event.getActionMasked();

        switch(action) {
            case MotionEvent.ACTION_DOWN:
                primaryPointerId = event.getPointerId(0);

                Log.d(getClass().getName(), "Primary pointer ID == [" + primaryPointerId + "]");

                break;

            case MotionEvent.ACTION_POINTER_DOWN:
                secondaryPointerId = event.getPointerId(event.getActionIndex());

                Log.d(getClass().getName(), "Secondary pointer ID == [" + secondaryPointerId + "]");

                break;

            case MotionEvent.ACTION_MOVE:
                if(primaryPointerId > -1 && secondaryPointerId > -1) {
                    Log.d(getClass().getName(), "Two-point touch...");
                } else {
                    Log.d(getClass().getName(), "One-point touch...");
                }

                break;

            case MotionEvent.ACTION_POINTER_UP:
                if(event.getPointerId(event.getActionIndex()) == primaryPointerId) {
                    primaryPointerId = secondaryPointerId;
                }

                secondaryPointerId = -1;

                break;

            case MotionEvent.ACTION_UP:
                primaryPointerId = -1;

                break;
        }

        return true;
    }
}