public class PhoneBook extends HashMap<String,Set<String>> {

   public PhoneBook() { }

   public PhoneBook(int initialCapacity) { super(initialCapacity); }

   // Use this method to add numbers to the phone-book
   // returns true if the phone directory changed as a result of the call.
   public boolean add(String name, String number) {
        String canonicalName = name.toLowerCase();
        Set<String> existingNumbers = super.get(name);
        if (existingNumbers == null) 
            super.put(canonicalName,existingNumbers = new HashSet<>(10)); 
        // give an estimate capacity per name, in this example 10.           
        return existingNumbers.add(number);
   }  

   @Override
   public Set<String> put(String name, Set<String> numberSet) {
        throw new UnsupportedOperationException("you must use add(String) to add numbers");
   }

   @Override
   public Set<String> get(String name) {
       String canonicalName = name.toLowerCase();
       Set<String> existingNumbers = super.get(canonicalName);
       return existingNumbers == null ? Collections.EMPTY_SET : existingNumbers;
   }

}