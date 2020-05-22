public class Fortest {
    Phone name = new Phone();

    public String handleUser(User user) {
        String ph = name.getA();

        if(ph.equalsIgnoreCase("test")){
            return "done";
        }

        return  "failed";

    } 
}