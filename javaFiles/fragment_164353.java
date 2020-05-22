public void publish(Event event) {
  eventBus.post(event);
  if(threadLocalException != null) {
    Store threadLocalException in some variable say e
    Clear threadLocalException variable
    throw e;
  }
}