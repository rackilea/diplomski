interface Runner1 {
    default void run() {
        System.out.println("default Runner1::run");
    }
}

interface Runner2 {
    default void run() {
        System.out.println("default Runner2::run");
    }
}

static class RunnerImpl implements Runner1, Runner2 {
    public void run() {
        super.run(); // which one???
    }
}