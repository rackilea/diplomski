public class SampleOverlayView extends OverlayView {

    private TextView info;

    private float x;
    private float y;

    public SampleOverlayView(OverlayService service) {
        super(service, R.layout.overlay, 1);
    }

    public int getGravity() {
        return Gravity.TOP + Gravity.RIGHT;
    }

    @Override
    protected void onInflateView() {
        info = (TextView) this.findViewById(R.id.textview_info);
    }

    @Override
    protected void refreshViews() {
        info.setText("WAITING\nWAITING");
    }

    @Override
    protected void onTouchEvent_Up(MotionEvent event) {w
        info.setText("UP\nPOINTERS: " + event.getPointerCount());
    }

    @Override
    protected void onTouchEvent_Move(MotionEvent event) {
        float newX = event.getX();
        float newY = event.getY();

        float deltaX = newX - this.x;
        float deltaY = newY - this.y;

        // Move this View

        this.x = newX;
        this.y = newY;
    }

    @Override
    protected void onTouchEvent_Press(MotionEvent event) {
        this.x = event.getX();
        this.y = event.getY();
    }

    @Override
    public boolean onTouchEvent_LongPress() {
        info.setText("LONG\nPRESS");
        return true;
    }
}