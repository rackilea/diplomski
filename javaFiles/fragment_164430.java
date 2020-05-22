// BoogieCarMain provides a sink for event-related information
public void handleSpeeding(BoogieCar car) {
  System.out.println(car.getSpeedingStatus());
}

// MySpeedListener knows about an object that wants event-related information.
// I've used the constructor but an addEventSink method or similar is probably better.
public MySpeedListener(BoogieCarMain eventSink) {
  this.eventSink = eventSink;
}

// MySpeedListener handles events, including informing objects that want related information.
// You decide if the event is an appropriate type for the sink to know about.
// Often it isn't, and instead your listener should pull the relevant info out of the event and pass it to the sink.
public void speedExceeded(BoogieSpeedEvent e) {
  if (e.getCurrentSpeed() > e.getMaxSpeed()) {
    // I've taken the liberty of adding the event source as a member of the event.
    eventSink.handleSpeeding(e.getCar());
  }
}