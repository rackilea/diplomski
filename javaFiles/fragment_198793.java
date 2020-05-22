public static void main(String[] args) throws Exception {
    final Process e = new Process();        
    Thread t = new Thread(new Runnable() {          
        @Override
        public void run() {
            try {
                Thread.sleep(10);
                e.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
    t.start();
    e.produce();
}