public class ButtonPane {

    private Consumer<String> messageHandler = s -> { } ;

    public void setMessageHandler(Consumer<String> messageHandler) {
        this.messageHandler = messageHandler ;
    }

    // ...

    // to handle a message, just do:
    // String message =  ... ;
    // messageHandler.accept(message);

}