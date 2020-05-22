public static void main(String[] args) {
    final BlockingQueue<String> bq = new LinkedBlockingQueue<String>(4);

    Runnable producer = new Runnable() {
        public void run() {
            try {
                bq.put("A");
                bq.put("B");
                bq.put("C");
                bq.put("D");
                bq.put("E");
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt(); 
            }
        }
    };
    Runnable consumer = new Runnable() {
        public void run() {
            try {
                System.out.println("1 = " + bq.take());
                System.out.println("2 = " + bq.take());
                System.out.println("3 = " + bq.take());
                System.out.println("4 = " + bq.take());
                System.out.println("5 = " + bq.take());
                System.out.println("6 = " + bq.take());
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    };
    new Thread(producer).start();
    new Thread(consumer).start();
}