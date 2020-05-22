for (User myUser: ...){
  Iterator<Event> it = myUser.getAttendingList().iterator();
  while (it.hasNext()) {
    Event myEvent = it.next();
    if (myEvent.getId()==eventID){
      it.remove();
    }
  }
}