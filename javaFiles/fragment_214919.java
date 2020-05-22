Registry registry = new Registry();
registry.registerCallback("hello", new Callback() {
    @Override 
    void call(String message) {
        System.out.println("Hello, here's your message: " + message);
    }
});

registry.invokeCallback("hello", "first message");