public void loadCursorPostDelayed(){
    final Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
        @Override
        public void run() {

            ContentResolver crs = globalContext.getContentResolver();
            ...
        }
    }, 1500);
}