public class MyImageView extends ImageView {
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        // at this point size and position are known
        int h = getHeight();
        int w = getWidth();
        doSomethingCool(h,w);
    }
}