public class TestView extends Activity {
    float x = 0;
    float y = 0;
    LinearLayout layout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view);
        layout=(LinearLayout)findViewById(R.id.viewd);
        layout.removeAllViews();
        CustomView view = new CustomView(TestView.this);
        view.setText("A");
        view.setLayoutParams(new LinearLayout.LayoutParams(
            250,
            340));
        layout.addView(view);
    }

    public class CustomView extends TextView {
        Bitmap mBitmap;
        Paint paint;
        Path path;

        public CustomView(Context context) {
            super(context);
            paint = new Paint();
            path= new Path();
            paint.setColor(Color.BLUE);
            paint.setStyle(Style.STROKE);
            paint.setStrokeWidth(5);
        }

        protected void onDraw(Canvas canvas) {
            canvas.drawPath(path,paint);
            canvas.drawCircle(x, y, 25, paint);
            super.onDraw(canvas);
        }

        public boolean onTouchEvent(MotionEvent event) {
            int action = event.getAction();
            switch (action) {
                case MotionEvent.ACTION_DOWN:
                    path.moveTo(event.getX(), event.getY());
                    path.lineTo(event.getX(), event.getY());
                    break;
                case MotionEvent.ACTION_MOVE:
                    x = event.getX();
                    y = event.getY();
                    path.lineTo(x, y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    path.lineTo(event.getX(), event.getY());
                    break;
                case MotionEvent.ACTION_CANCEL:
                    break;
                default:
                    break;
            }
            return true;
        }
    }
}