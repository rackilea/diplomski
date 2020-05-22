public class ResizeAnimation extends Animation
{
    int _startWidth;
    int _targetWidth;
    View _view;
    private int _targetHeight;
    private int _startHeight;

    public ResizeAnimation(View view, int targetWidth, int targetHeight)
    {
        _view = view;
        _targetWidth = targetWidth;
        _startWidth = view.getWidth();

        _targetHeight = targetHeight;
        _startHeight = view.getMeasuredHeight();
        setFillAfter(true);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t)
    {
        int newWidth = (int) (_startWidth + (_targetWidth - _startWidth) * interpolatedTime);
        int newHeight = (int) (_startHeight + (_targetHeight - _startHeight) * interpolatedTime);

        _view.getLayoutParams().width = newWidth;
        _view.getLayoutParams().height = newHeight;
        _view.requestLayout();
    }

    @Override
    public boolean willChangeBounds()
    {
        return true;
    }
}