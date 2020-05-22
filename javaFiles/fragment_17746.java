public static void main(String[] args) throws Exception {
    final BlockingQueue<Runnable> r = new LinkedBlockingQueue<>();
    final Thread t = new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                try {
                    r.take().run();
                } catch (InterruptedException ex) {
                    return;
                }
            }
        }
    });
    r.add(new Runnable() {

        @Override
        public void run() {
            //do stuff
        }
    });
}