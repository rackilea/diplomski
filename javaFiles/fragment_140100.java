public void someMethodInRenderer() {
   if( stop ) {
      stop();
   }
}

public void stop() {
   Handler handler = new Handler();
   handler.post( new Runnable() {
      public void run() {
         activity.finish();
      }
   } );
}