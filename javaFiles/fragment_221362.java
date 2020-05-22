public class JavaReply extends BusModBase {

    @Override
    public void start() {
        eb.registerHandler("invokeFromAnyLanguage", new Handler<Message<String>>(){
            public void handle(Message<String> e) {
                String something = doSomething();
                e.reply(something);
            }                
        });           
    }

    private String doSomething() {
        // your database code here
        return "databaseResult";
    }

}