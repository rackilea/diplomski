public class Foo {
   private List<String> strings = new ArrayList() {{ add("bar");}};
   private Object veryLargeField; //the object stored here consumes a lot of memory

   public List<String> getStrings() {
     return strings;
   }
}