WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);

Drawable drawable = getResources().getDrawable(R.drawable.wallpaper);

Bitmap wallpaper = ((BitmapDrawable) drawable).getBitmap();

wallpaperManager.setBitmap(wallpaper);