public static void main(String[] args) throws InterruptedException {
    Example sharedData = new Example();
    Thread incrementer = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++)
                sharedData.increment();
            System.out.println("Incrementer finished");
        }
    });
    Thread decrementer = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++)
                sharedData.decrement();
            System.out.println("Decrementer finished");
        }
    });
    incrementer.start();
    decrementer.start();
    incrementer.join();
    decrementer.join();
    System.out.println(sharedData.count);
}