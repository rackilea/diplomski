public int compare(AbstractEvent event1, AbstractEvent event2) {        
  int result = 0;       
  if (event1.hasMoreOccurrences() && event2.hasMoreOccurrences())
    result = event1.nextOccurrence().compareTo(event2.nextOccurrence());
  return result;
}