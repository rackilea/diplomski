public class DataStorage {
    private HashMap<String, Integer> people = new HashMap<String, Integer>();

    public HashMap<String, Integer> getPeopleMap() {
         return people;
    }
}

public class AnotherClass {
      DataStorage x = new DataStorage();       

      private void someMethod() {
           HashMap<String, Integer> people = x.getPeopleMap();
           //work with your map here...
      }  
}