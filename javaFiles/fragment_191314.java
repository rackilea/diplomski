new Thread(new Runnable() {
    public void run() {
        System.out.println("Look ma, no hands");
    }
}).start();

new Thread(new Runnable() {
    public void run() {
        System.out.println("Look at me, look at me...");
    }
}).start();