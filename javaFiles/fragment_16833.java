boolean wallpaperWasSetByAnotherApp() {
     WallpaperManager wp_mngr = (WallpaperManager) getSystemService(WALLPAPER_SERVICE);
     WallpaperInfo info = wp_mngr.getWallpaperInfo();
     if (info == null) {
         // wallpaper is a static image
         return true; 
     } else {
         // wallpaper is live, check implementing service
         return !info.getComponent().equals(new ComponentName(this, getClass()));
     }
}