import java.util.HashMap;
import java.util.HashSet;

public class MyClass {

    public static void main(String[] args) {

        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        hm.put(1, "Anil");
        hm.put(2, "Deven");
        hm.put(3, "sanjay");
        hm.put(4, "sanjay");
        hm.put(5, "Raj");
        hm.put(6, "sanjay");

        HashSet<String> hm2 = new HashSet<String>();
        hm2.addAll(hm.values());

        for (String str : hm2){
            System.out.println(str);
        }
    }

}