public static int sum(List list){
  int sum=0;
  for (Iterator i = list.iterator(); i.hasNext(); ) {
    Number n = (Number) i.next();
    sum += n.intValue();
  }
  return sum;
}