public static void main(String[] args) {

     Runnable r = new Runnable() {
         public void run() {
             runYourBackgroundTaskHere();
         }
     };

     new Thread(r).start();
     //this line will execute immediately, not waiting for your task to complete
}