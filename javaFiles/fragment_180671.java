private static AtomicInteger balance = new AtomicInteger();

    private static void showBalance() {
        return balance.get();
    }

    private static void setBalance(int amt) {
        balance.set(amt);
    }

    private static void deposit(int deposit){
       balance.getAndAdd(deposit);
    }

    public static void main(String[] args)throws InterruptedException {
        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run() {
                setBalance(10);
                System.out.println("Initial Balance\t"+balance);
            }

        });
        thread1.start();
        thread1.join();//join after completion of thread1 
                //(i.e., displays Initial Balance)

        Thread thread2 = new Thread(new Runnable(){
            @Override
            public void run() {
                showBalance();
                System.out.println(" Balance\t"+balance);
            }

        });
       thread2.start();
       thread2.join();

        Thread thread3 = new Thread(new Runnable(){
            @Override
            public void run() {
                deposit(10);
                System.out.println("Balance after deposit\t"+balance);
            }

        });
        thread3.start();
    }