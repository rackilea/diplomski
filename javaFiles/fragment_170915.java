Thread thread = new Thread(new Runnable(){
     public void run() {
         new FaceDetector();
     }
});

thread.start();