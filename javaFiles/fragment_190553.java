public static void main(String[] args) throws InterruptedException {
    Observer obs = new Observer();
    EventBus.subscribe(obs, SomeEventImp.class);

    SomeEventImp evt = new SomeEventImp(new Object(), "This is the value");

    EventBus.publishAsync(evt);

    Thread.sleep(Long.MAX_VALUE);
}