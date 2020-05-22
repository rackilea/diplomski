int i=0;
Iterator<Date> it = dates.iterator();
while(i<3 && it.hasNext()) {
  Date date = it.next();
  doSomething();
  i++
}