static class Singleton {
    static Singleton i;

    static Singleton getInstance() {
        if (i == null) {
            i = new Singleton();
        }
        return i;
    }
}

public static void main(String[] args) throws Exception {
    Callable<Singleton> c = new Callable<Singleton>() {
        @Override
        public Singleton call() throws Exception {
            return Singleton.getInstance();
        }
    };
    ExecutorService ex = Executors.newFixedThreadPool(2);
    for(;;) {
        Future<Singleton> f1 = ex.submit(c);
        Future<Singleton> f2 = ex.submit(c);
        if (f1.get() != f2.get()) {
            System.out.println("!!!");
        }
        Singleton.i = null;
    }
}