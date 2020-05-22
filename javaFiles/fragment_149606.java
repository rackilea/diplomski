Collections.sort(myList, new Comparator<Event>() {
  public int compare(Event o1, Event o2) {
      if (o1.getDateTime() == null || o2.getDateTime() == null)
        return 0;
      return o1.getDateTime().compareTo(o2.getDateTime());
  }
});