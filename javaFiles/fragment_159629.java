WallpaperSerEngine() {
    diwaliImg = new Runnable() {
        public void run() {
            drawFrame();
        }
    };        
    initMainBitmap(getResources(),pirates[0]);
}