@Override
public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint)
{
    shadowSize.set((int) width + 1, (int) height + 1);

    float x = offsetX - w / 2, y = offsetY - h / 2;
    shadowTouchPoint.x = Math.round(x * c - y * s * sFac + w / 2 + (width - w) / 2);
    shadowTouchPoint.y = Math.round(x * s * sFac + y * c + h / 2 + (height - h) / 2);
}