public class CustomRelativeLayout extends RelativeLayout {

    ImageView imageView;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        imageView = (ImageView) findViewById(R.id.image_view);
    }
}