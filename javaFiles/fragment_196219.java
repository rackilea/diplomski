class Inner {
    public static void main(String[] args) {
        Runnable r = new Runnable() { public void run() {} };
        r.run();
    }
}

class Lambda {
    public static void main(String[] args) {
        Runnable r = () -> {};
        r.run();
    }
}