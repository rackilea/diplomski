public void foo() {
    final int x = 3;
    final Object z = new Object();
    new Thread() {
        public void run() {
            for(int i = 0; i < x; i++) {
                System.out.println(z);
            }
        }
    }.start();
}