public class TargetDragShadowBuilder extends View.DragShadowBuilder
{
    ImageView view;
    float offsetX, offsetY;

    double rotationRad;
    float w;
    float h;
    double s;
    double c;
    float width;
    float height;

    public TargetDragShadowBuilder(final ImageView view, float offsetX, float offsetY)
    {
        super(view);
        this.view = view;
        this.offsetX = offsetX * view.getScaleX();
        this.offsetY = (int) (offsetY * view.getScaleY());

        rotationRad = Math.toRadians(view.getRotation());
        w = view.getWidth() * view.getScaleX();
        h = (int) (view.getHeight() * view.getScaleY());
        s = Math.abs(Math.sin(rotationRad));
        c = Math.abs(Math.cos(rotationRad));
        width = (int) (w * c + h * s);
        height = (int) (w * s + h * c);
    }

    @Override
    public void onDrawShadow(Canvas canvas)
    {
        canvas.scale(view.getScaleX(), view.getScaleY(), width / 2, height / 2);
        canvas.rotate(view.getRotation(), width / 2, height / 2);
        canvas.translate((width - view.getWidth()) / 2, (height - view.getHeight()) / 2);

        super.onDrawShadow(canvas);
    }

    @Override
    public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint)
    {
        shadowSize.set((int) width + 1, (int) height + 1);

        double x = offsetX, y = offsetY;
        if(rotationRad < 0)
        {
            final double xC = offsetX / c;
            x = xC + s * (offsetY - xC * s);
            final double yC = offsetY / c;
            y = yC + s * (w - offsetX - yC * s);
        }
        else if(rotationRad > 0)
        {
            final double xC = offsetX / c;
            x = xC + s * (h - offsetY - xC * s);
            final double yC = offsetY / c;
            y = yC + s * (offsetX - yC * s);
        }

        shadowTouchPoint.x = (int) Math.round(x);
        shadowTouchPoint.y = (int) Math.round(y);
    }
}