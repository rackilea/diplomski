public static void main(String[] args) throws Exception {
    final Thread t = new Thread(new Runnable() {

        @Override
        public void run() {
            System.out.println("Do stuff");
        }
    });
    t.start();
    t.join();
}