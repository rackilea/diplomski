public class DrawOrbit extends View
{
    PointF center;
    float radius[];
    int index;
    public DrawOrbit(Context context) {
        super(context);
    }

    public DrawOrbit(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawOrbit(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);

        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.STROKE);
        int len=radius.length;
        for(int a=0;a<index;a++)
        {
            canvas.drawCircle(center.x,center.y,radius[a],paint);
        }
    }   

    public void draw(PointF center, float radius[],int index)
    {
        this.center=center;
        this.radius=radius;
        this.index=index;
        invalidate();        
        requestLayout();
    }
}