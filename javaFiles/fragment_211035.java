@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = (ImageView) findViewById(R.id.imageview);

        imageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                BitmapDrawable drawable = null;
                if (Build.VERSION.SDK_INT >= 21) {
                    drawable = (BitmapDrawable) getResources().getDrawable(R.drawable.sunset, getTheme());
                } else {
                    drawable = (BitmapDrawable) getResources().getDrawable(R.drawable.sunset);
                }
                Bitmap bitmap = drawable.getBitmap();

                // get the scale factor that will have to be applied to
                // the image to make it the same height as your ImageView
                float factor = (float) imageView.getHeight() / (float) bitmap.getHeight();

                // now the image will have to be shifted over all of its
                // width minus the width of the ImageView.  This will make
                // the right edges line up.
                int scaledImageWidth = (int) (bitmap.getWidth() * factor);
                int translateX = imageView.getWidth() - scaledImageWidth;

                // you can also use drawable.getIntrinsicWidth() and
                //     drawable.getIntrinsicHeight()

                Matrix matrix = new Matrix();
                matrix.setScale(factor, factor);
                matrix.postTranslate(translateX, 0);

                imageView.setScaleType(ImageView.ScaleType.MATRIX);
                imageView.setImageMatrix(matrix);
                imageView.setImageBitmap(bitmap);
            }
        });
    }