public static void init() {
   new Thread(new Runnable() {
      public void run() {
         for (int i = 0; i < 600 * 3; i++) {
              names.add(NameGenerator.generateName());  
         }
     }
   }).start();
}