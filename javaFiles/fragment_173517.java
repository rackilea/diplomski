public String getStartedAt(){
  //check if the busyAt List contains items or not.
  if (busyAt ==null || busyAt.isEmpty()){
    return "";
  }
  //take the list of events from the first busyAt in the array
  List<Event> eventList = busyAt.get(0).getEvents();
  //check if the event List contains items or not.
  if (eventList ==null || eventList.isEmpty()){
    return "";
  }
  //return the StartAt value of the first event.
  return eventList.get(0).getStartedAt(); 
}