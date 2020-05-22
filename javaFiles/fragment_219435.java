List<Integer> a = new ArrayList<Integer>(Arrays.asList(1,2,3));
List<Integer> b = new ArrayList<Integer>(Arrays.asList(4,5,6));
List<String> c = new ArrayList<String>(Arrays.asList("a","","c"));

Iterator<Integer> a_iterator = a.iterator();
Iterator<Integer> b_iterator = b.iterator();
Iterator<String> c_iterator = c.iterator();

while (c_iterator.hasNext() && b_iterator.hasNext() && a_iterator.hasNext()){
   a_iterator.next();
   b_iterator.next();
   String cString = c_iterator.next();
   if (cString == null || cString.isEmpty()){
     a_iterator.remove();
     b_iterator.remove();
     c_iterator.remove();
   }
}