@Override
public Object instantiateItem(ViewGroup view, final int position) {
    View imageLayout = inflater.inflate(R.layout.item_pager_image, view, false);
    assert imageLayout != null;
    final ImageView imageView = (ImageView) imageLayout.findViewById(R.id.image);
    final ProgressBar spinner = (ProgressBar) imageLayout.findViewById(R.id.loading);
    final View makePrimaryLayout =imageLayout.findViewById(R.id.makePrimaryLayout);
    makePrimaryLayout.setVisibility(View.GONE);

    Button makePrimBtn = (Button)imageLayout.findViewById(R.id.btnPrime);
    makePrimBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            WallpaperManager myWallpaperManager = WallpaperManager.getInstance(getApplicationContext());
            try {
                // below line of code will set your current visible pager item to wallpaper
                // first we have to fetch bitmap from visible view and then we can pass it to wallpaper

                imageView.buildDrawingCache();
                Bitmap bmp = imageView.getDrawingCache();

                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);
                int height = metrics.heightPixels;
                int width = metrics.widthPixels;
                Bitmap bitmap = Bitmap.createScaledBitmap(bmp , width, height, true);
                myWallpaperManager.setWallpaperOffsetSteps(1, 1);
                myWallpaperManager.suggestDesiredDimensions(width, height);
                myWallpaperManager.setBitmap(bitmap);

                // below line of code will set input stream data directly to wallpaper
                // myWallpaperManager.setStream(InputStream Data);

                // below line of code will set any image which is in the drawable folder
                // myWallpaperManager.setResource(R.drawable.icon);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    });

    imageLoader.displayImage(images[position], imageView, options, new SimpleImageLoadingListener() {
        @Override
        public void onLoadingStarted(String imageUri, View view) {
            spinner.setVisibility(View.VISIBLE);
        }

        @Override
        public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
            String message = null;
            switch (failReason.getType()) {
                case IO_ERROR:
                    message = "Input/Output error";
                    break;
                case DECODING_ERROR:
                    message = "Image can't be decoded";
                    break;
                case NETWORK_DENIED:
                    message = "Downloads are denied";
                    break;
                case OUT_OF_MEMORY:
                    message = "Out Of Memory error";
                    break;
                case UNKNOWN:
                    message = "Unknown error";
                    break;
            }
            Toast.makeText(ImagePagerActivity.this, message, Toast.LENGTH_SHORT).show();

            spinner.setVisibility(View.GONE);
        }

        @Override
        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

        }
    });

    view.addView(imageLayout, 0);
    return imageLayout;
}