@EventMapping(value ="{http://liferay.com/events}ipc.messsage")
public void receiveEvent(EventRequest request, EventResponse response) {
    Event event = request.getEvent();
    String messsage = (String)event.getValue();
    //process the message
}