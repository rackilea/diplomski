public void callback(final double[] myDoubles)
{
  new Thread(){
   public void run() {
      // you can use myDoubles here. it will run on a separate thread.
   }}.start()   
};