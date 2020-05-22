public static void main(String[] args) {
    GsonBuilder gb = new GsonBuilder();

    // Register the Message class since I need to access info in the header
    gb.registerTypeAdapter(Message.class, new MessageDeserializer());
    gb.registerTypeAdapter(Message.class, new MessageSerializer());

    Gson gson = gb.setPrettyPrinting().create();

    EventBody event = new EventBody(EventType.SOME_EVENT_NAME);

    String eventJson = gson.toJson(event.getAsMessage());
    System.out.println(eventJson);

    Message newEvent = gson.fromJson(eventJson);
    System.out.println("\nEvent type: " + ((EventBody) newEvent.getBody()).getEventName());
}