public class Whatever {
   private final List<String> myList;

   public Whatever() {
     myList = new ArrayList<String>();
   }

   public Whatever(String name) {
     this();
     // Other stuff done
   }

   public Whatever(List<String> myList) {
     this.myList = myList;
   }
}