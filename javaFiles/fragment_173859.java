public static void main(String[] args) {
     String[] firstNames = {"Pete", "Jon", "Fred"};
     String[] lastNames = {"Klein", "Jones", "Flinstone"};
     String phoneNumber = "555-123-4567";

      for (int i = 0; i < firstNames.length; i++) {
        String foo = String.format("%-20s %s", lastNames[i] + ", " + 
             firstNames[i], phoneNumber);
        System.out.println(foo);
      }   
   }