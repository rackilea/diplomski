long start = startDate.getLocalMillis();
long end = endDate.getLocalMillis();
long interval = (end-start)/numberOfIntervals;
for(long i = start+interval; i < end; i+=interval){
  LocalDate ld = new LocalDate(i);
  //do something with ld
}