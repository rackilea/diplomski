public class CustomRelativeLayout extends RelativeLayout {

    private ImageView imageView;

    public CustomRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.custom_relative_layout, this);

        imageView = (ImageView) findViewById(R.id.image_view);
    }
}