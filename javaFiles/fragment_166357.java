public class TouchController {
    private Context mContext;

    public TouchController(Context c) {   //constructor
        mContext = c;

        View.OnTouchListener touch = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (maskedAction) {
                    //do stuff
                }
                return true;
            }
        };

        //Register touch listener here in constructor or in another method
        CourseListActivity.glView.setOnTouchListener(touch);
    }

}