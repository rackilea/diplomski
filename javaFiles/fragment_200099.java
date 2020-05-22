public class ThirdActivity extends ActionBarActivity {

    private static final int REQUEST_IMAGE = 0;

    private Bitmap bitmapToResize;

    private Button mGetImageButton;
    private Button mResizeButton;
    private ImageView mImageViewForGallery;
    private ImageView mImageVIewForDrable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        mGetImageButton = (Button) findViewById(R.id.button_getImage);
        mGetImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // SET action AND miniType
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_PICK);
                intent.setType("image/*");
                // REQUEST Uri of image
                startActivityForResult(intent, REQUEST_IMAGE);
            }
        });

        mResizeButton = (Button) findViewById(R.id.button_resize);
        mResizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resize();
            }
        });

        mImageViewForGallery = (ImageView) findViewById(R.id.imageView);

        mImageVIewForDrable = (ImageView) findViewById(R.id.imageViewFromDrable);
        mImageVIewForDrable.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK) {return;}

        if (requestCode == REQUEST_IMAGE) {
            Uri uri = data.getData();
            // SET image
            mImageViewForGallery.setImageURI(uri);
            Drawable drawable = mImageViewForGallery.getDrawable();
            Log.e("asd", "Height:" + drawable.getIntrinsicHeight());
            Log.e("asd", "Width:" + drawable.getIntrinsicWidth());
        }
    }

    private void resize() {
        if (mImageViewForGallery.getDrawable() != null) {
            bitmapToResize = drawableToBitmap(mImageVIewForDrable.getDrawable());
            int width = mImageViewForGallery.getDrawable().getIntrinsicWidth();
            int height = mImageViewForGallery.getDrawable().getIntrinsicHeight();
            bitmapToResize = zoomBitmap(bitmapToResize, width, height);
            mImageVIewForDrable.setImageBitmap(bitmapToResize);
        } else {
            Log.e("asd", "setImageFirst");
        }

    }

    public static Bitmap zoomBitmap(Bitmap bitmap, int w, int h) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        float scaleWidht = ((float) w / width);
        float scaleHeight = ((float) h / height);
        matrix.postScale(scaleWidht, scaleHeight);
        Bitmap newbmp = Bitmap.createBitmap(bitmap, 0, 0, width, height,
                matrix, true);
        return newbmp;
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        Bitmap bitmap = Bitmap.createBitmap(width, height, drawable
                .getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmap;
    }

}