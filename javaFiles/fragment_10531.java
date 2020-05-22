public List<Integer> convert(List<? extends Number> source) {
   List<Integer> target = new ArrayList<>();
   for (Number number : source) {
      target.add(number.intValue());
   }
   return target;
}