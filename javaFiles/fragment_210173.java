public static <T extends Number> int sum(List<T>list){
  int sum=0;
  for (Iterator<Number> i = list.iterator(); i.hasNext(); ) {
    Number n = (Number) i.next();
    sum += n.intValue();
  }
  return sum;
}