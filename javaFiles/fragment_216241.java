public class Fortest {
    Phone name;
    Fortest(Phone name) {
        this.name = name;
    }

    public String handleUser(User user) {
        String ph = name.getA();

        if(ph.equalsIgnoreCase("test")){
            return "done";
        }

        return  "failed";

    } 
}


public class TestFortest {
   @Before
   public void before() {
          name = ; //... 
          subject = new Fortest(name);
   }
}