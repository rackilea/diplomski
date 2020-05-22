public class CustomRelativeLayout extends RelativeLayout {

    private ImageView imageView;

    public CustomRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        imageView = new ImageView(context);
        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        imageView.setLayoutParams(layoutParams);
        addView(imageView);
    }
}