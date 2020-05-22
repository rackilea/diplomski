ImageView view  = findViewById(R.id.imageLogo);
       AssetManager assetManager = getAssets();
        InputStream istr = null;
        try {
            //R.string.yourstring will be like "sample.png"
            istr = assetManager.open(getResources().getString(R.string.yourstring));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(istr);
    view.setImageBitmap(bitmap);