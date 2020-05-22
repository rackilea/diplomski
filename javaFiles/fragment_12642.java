public void myMethod() {
   final String foo = "Hello"; // again it must be final if used in 
                               // an anon inner class

   new Thread(new Runnable() {
      public void run() {
         for (int i = 0; i < 10; i++) {
            System.out.println(foo);
            try {
             Thread.sleep(1000);
            } catch (Exception e) {}

         }
      }
   }).start();
}