class MyClass {
   public static ArrayList<A> myList = new ArrayList<>(
                                       Arrays.asList(new A[]{ A1, A2, ..., AN);

   public static void main(String[] args) {
       // iterate over your list
       for(A a : myList) {
          // do something with A object
       }
   }
}