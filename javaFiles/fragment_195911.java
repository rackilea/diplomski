final String name = getName();

Thread t = new Thread(new Runnable() {
    @Override public void run() {
        System.out.println(name);
    }
});
t.start();