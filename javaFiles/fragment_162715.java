int i=0;
for(Iterator<Date> it = dates.iterator(); it.hasNext() && i<3;) {
  Date date = it.next();
  doSomething();
  i++
}