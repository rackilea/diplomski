private class TargetDragListener implements OnDragListener
{
    @Override
    public boolean onDrag(View v, DragEvent e)
    {
        switch(e.getAction())
        {
            case DragEvent.ACTION_DRAG_STARTED:
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                break;
            case DragEvent.ACTION_DROP:
                if(e.getLocalState() instanceof TargetItem)
                {
                    TargetItem target = (TargetItem) e.getLocalState();
                    dropTarget(target, e.getX(), e.getY());
                }
                break;
            case DragEvent.ACTION_DRAG_ENDED:
                ((DragableItem) e.getLocalState()).setVisibility(View.VISIBLE);
            default:
                break;
        }
        return true;
    }
}

private void dropTarget(TargetItem target, float x, float y)
{
    target.setDragged(false);
    target.setVisibility(View.VISIBLE);
    target.bringToFront();

    final float scaleX = target.getScaleX(), scaleY = target.getScaleY();
    double rotationRad = Math.toRadians(target.getRotation());
    final float w = target.getWidth() * scaleX;
    final float h = target.getHeight() * scaleY;
    float s = (float) Math.abs(Math.sin(rotationRad));
    float c = (float) Math.abs(Math.cos(rotationRad));
    float sFac = (float) -Math.signum(rotationRad);

    target.offsetX *= scaleX;
    target.offsetY *= scaleY;

    x += -target.offsetX * c - target.offsetY * s * sFac;
    y += target.offsetX * s * sFac - target.offsetY * c;
    float[] pts = { x, y };
    float centerX = x + c * w / 2f + sFac * s * h / 2f;
    float centerY = y - sFac * s * w / 2f + c * h / 2f;

    transform.setRotate(-target.getRotation(), centerX, centerY);
    transform.mapPoints(pts);

    target.setX(pts[0] + (w - target.getWidth()) / 2);
    target.setY(pts[1] + (h - target.getHeight()) / 2);
}