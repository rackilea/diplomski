button.setText(shop.getName());
    Drawable icon;
    int s = shop.getId();
    String sk = Integer.toString(s);
    String imageUri = "file:///android_asset/shop"+sk+".png";
    Log.w("imageURI", imageUri);
    Uri uri=Uri.parse(imageUri);

    InputStream is;
    try {
        is = this.getContentResolver().openInputStream( uri );
        BitmapFactory.Options options=new BitmapFactory.Options();
        options.inSampleSize = 10;
        Bitmap preview_bitmap=BitmapFactory.decodeStream(is,null,options);

        Drawable icon = new BitmapDrawable(getResources(),preview_bitmap);

    } catch (FileNotFoundException e) {
        //set default image from the button
        icon = getResources().getDrawable(R.drawable.shopping1);
    }    

    button.setBackground(icon);