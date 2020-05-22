public class ScreenView extends View {

    private Context context;
    private Paint paintLine = new Paint(Paint.ANTI_ALIAS_FLAG);

    public ViewStats(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public ViewStats(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public ViewStats(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        init();
    }

    private void init() {
        paintLine.setStyle(Paint.Style.FILL_AND_STROKE);
        paintLine.setColor(0xFFE4455B);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Random random = new Random();
        canvas.drawRGB(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        invalidate();
    }
}