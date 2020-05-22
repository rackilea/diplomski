Handler handler = new Handler(Looper.getMainLooper());
handler.post(new Runnable() {
     @Override
     public void run() {
         cameraSource.release();
     }
});