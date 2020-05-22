public <T> void sendEvent(final List <? extends T> batch, Function <T, String> toJson) {
    batch .forEach (value -> {
         String json = toJson (value);
         // send over rabbit
    });
}