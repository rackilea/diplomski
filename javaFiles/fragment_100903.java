ImageView img = (ImageView) findViewById(R.id.myImageId);
img.setOnClickListener(new OnClickListener() {
    public void onClick(View v) {
      WallpaperManager myWallpaperManager
     = WallpaperManager.getInstance(getApplicationContext());
    try {
     Bitmap bitmap=((BitmapDrawable)img.getDrawable()).getBitmap();
     if(bitmap!=null)
     myWallpaperManager.setBitmap(bitmap);
    } catch (IOException e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
    }
    }
});