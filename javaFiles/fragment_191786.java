holder.setwallpaper.setOnClickListener(v -> {
        try {
       WallpaperManager wallpaperManager = WallpaperManager.getInstance(mcontext); 
       Drawable drawable = imageview.getDrawable(position);
//or if the above line of code doesn't work try fetching the image from your array list
imagelist.get(position).image
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                wallpaperManager.setBitmap(bitmap);
        } catch (IOException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
        }


            });