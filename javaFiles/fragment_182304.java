Thread t = new Thread () {
   @Override
   public void run() {
       for (int i = 0;   i < 5;  i++) {
           System.out.println("hello kakke - from separate Thread");
           Thread.sleep(500);
       }
   }
};
t.start();

for (int i = 0;   i < 5;  i++) {
    System.out.println("hello kakke - from main Thread");
    Thread.sleep(700);
}