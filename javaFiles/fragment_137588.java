public enum ListenerEnum implements EventListener{

    INSTANCE;

    private int counter;
    private static final ExecutorService exec; //this looks strange. I'd move this service out of enum.
    private static final EventProducer ep;

    static{
            exec = Executors.newSingleThreadExecutor();
            ep = new EventProducer(INSTANCE); //Automatically unregisters when the producer is done.
            exec.submit(ep); 
    }

    @Override
    public void doSomething() {
        System.out.println("Did something.");
        counter++;
        if (counter >= 5) {
            exec.shutdownNow();
        }
    }
}