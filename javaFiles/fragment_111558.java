@Override
public void start(Stage primaryStage) {
    System.out.println("--> in start: " + Thread.currentThread().getName());
    Thread.dumpStack();
    run();
}


            @Override
            protected Void call() throws Exception {
                System.out.println("called in thread: " + Thread.currentThread().getName());
                Thread.dumpStack();
                return null;
            }