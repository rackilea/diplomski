public class RoundedDashView extends View {

public enum Orientation {
    VERTICAL,
    HORIZONTAL
}

private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
private Path path = new Path();
private Orientation orientation = Orientation.HORIZONTAL;

public RoundedDashView(Context context) {
    super(context);
    init();
}

public RoundedDashView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init();
}

public RoundedDashView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
}

public RoundedDashView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    init();
}

private void init() {
    paint.setStyle(Paint.Style.STROKE);
    paint.setStrokeCap(Paint.Cap.ROUND);
    paint.setStrokeWidth(10);
    paint.setColor(Color.GRAY);
    paint.setPathEffect(new DashPathEffect(new float[]{20, 25}, 20));
}

@Override
protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    path.reset();
    if (orientation == Orientation.VERTICAL) {
        path.moveTo(getWidth() / 2, 0);
        path.quadTo(getWidth() / 2, getHeight() / 2, getWidth() / 2, getHeight());
    } else {
        path.moveTo(0, getHeight() / 2);
        path.quadTo(getWidth() / 2, getHeight() / 2, getWidth(), getHeight() / 2);
    }
    canvas.drawPath(path, paint);
}

public void setOrientation(Orientation orientation) {
    this.orientation = orientation;
    invalidate();
}
}