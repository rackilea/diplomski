import java.util.*;

public class Main {
    public static void main(String[] args) {
        UserImpl userImpl = new UserImpl(); 
        HashMap<String, Double> records = userImpl.getRecords();
        System.out.println("The size of the map is " + records.size());
        System.out.println("Initial Mappings are: " + records); 
        userImpl.updateVideoRecord("theCurrentVideo", 360);
        System.out.println("The size of the map is " + records.size());
        System.out.println("Initial Mappings are: " + records); 
   }
}