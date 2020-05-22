public class Handler {

    private Dispatcher dispatcher = new Dispatcher();

    public void dispatchMessage(MessageHandler handler, String argument1, String argument2, Long argument3) {

        handler.registerMessage(() -> {
            dispatcher.dispatch(argument1,
                    argument2,
                    argument3);
        });

    }

    interface MessageHandler {
        void registerMessage(Runnable run);
    }

    static class Dispatcher {
        void dispatch(String a, String b, long c){
            // Do dispatch
        }
    }
}