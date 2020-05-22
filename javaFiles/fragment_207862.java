public static void main(String[] args) throws Exception {
    Injector injector = Guice.createInjector(new WorkerModule());

    Worker worker = injector.getInstance(Worker.class);
    worker.run();
}