void foo() {
    final Object something = new String("I'm alive!");
    new Thread() {
        public void run() {
            try {Thread.sleep(10000);} catch (InterruptedException e) {}
            System.out.println(something);
        }
    }.start();
}