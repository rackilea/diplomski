public class JavaFromEverywhere extends Verticle {

    @Override
    public void start() throws Exception {
        vertx.eventBus().registerHandler("invokeFromAnyLanguage", new Handler<Message<String>>(){
            public void handle(Message<String> e) {
                doSomething();
            }

        });
    }

    private void doSomething() {
        // your database code here
    }

}