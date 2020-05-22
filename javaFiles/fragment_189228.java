public void delay(String station, int minutes) {
  boolean startDelay = false;
  ListIterator<Station> sIt = schedule.listIterator();
  while (sIt.hasNext()) {
    Station currStation = sIt.next();
    if (!startDelay && currStation.getCity().equals(station)) {
      startDelay = true;
    }
    if( startDelay ){
      currStation.delay(minutes);
    }
  }
}