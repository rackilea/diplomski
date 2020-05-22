public class MyTest{
     private Airport airport; // declare as a private class member

     @Before
     public void setUp() {
         airport = new Airport(); // instantiate it before every test
     }

     @Test
     public void has_storage(){
         ArrayList<String> airport_storage;
         airport_storage = new ArrayList<String>();
         airport_storage.add("plane");
         ArrayList<String> actual_storage = airport.storage(); // use it without problems
     }
}