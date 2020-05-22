private void setThemeBackgroundImage(String imageName, Button themeButton) {

        try {
            InputStream backgroundBitmap = getAssets().open(imageName);
            Bitmap immutableBitmap = BitmapFactory
                    .decodeStream(backgroundBitmap);

            themeButton.setBackgroundDrawable(new BitmapDrawable(
                    getResources(), immutableBitmap));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }