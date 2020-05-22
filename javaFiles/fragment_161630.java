Handler mHandler = new Handler(Looper.getMainLooper());
...
...
...
private Emitter.Listener onMessage = new Emitter.Listener() {

   @Override
   public void call(Object... args) {

      mHandler.post(new Runnable(){

         @Override
         public void run (){
         addView();
         }
     });
};