public void method() {
    new Thread(new Runnable() {
        public void run() {
            //code
        }
    }).start();

   new Thread(new Runnable() {
        //run method
   }).start();
}