int a = 7;
Runnable r = new Runnable() {
    public void run() {
        a = 5;
    }
};
r.run();
System.out.println(a);