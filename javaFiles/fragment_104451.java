private class SetWallpaperTask extends AsyncTask<Void, Void, Void> {

  Drawable wallpaperDrawable;

  @Override
  protected void onPreExecute() {
    // Runs on the UI thread
    // Do any pre-executing tasks here, for example display a progress bar
    Log.d(TAG, "About to set wallpaper...");
  }

  @Override
  protected Void doInBackground(Void... params) {
    // Runs on the background thread
    WallpaperManager wallpaperManager = WallpaperManager.getInstance
      (getApplicationContext());
    wallpaperDrawable = wallpaperManager.getDrawable();
  }

  @Override
  protected void onPostExecute(Void res) {
    // Runs on the UI thread
    // Here you can perform any post-execute tasks, for example remove the
    // progress bar (if you set one).
    if (wallpaperDrawable != null) {
      wallpaperDrawable.setAlpha(50);
      getWindow().setBackgroundDrawable(wallpaperDrawable);
      Log.d(TAG, "New wallpaper set");
    } else {
      Log.d(TAG, "Wallpaper was null");
    }
  }

}