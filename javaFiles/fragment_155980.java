public class ImageViewerActivity extends Activity {
    private static final String EXTRA_IMAGE_ID = "ImageViewerActivity.EXTRA_IMAGE_ID";
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Bundle extras = getIntent().getExtras();
    if (extras == null) {
        return;
    }

        Resource resId = extras.getInt(EXTRA_IMAGE_ID);
        mImageView.setImageDrawable(resId);
}