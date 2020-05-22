import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Testing {

    public static void main(String[] args) {
        HashMap<String, String> hm = new LinkedHashMap<String, String>();

        String[] values = {"1","2","3"};
        ArrayList<String> ar = new ArrayList<String>();
        ar.add("test@gmail.com");
        ar.add("any@gmail.com");
        ar.add("test@gmail.com");


        for (int i = 0; i<ar.size();i++) {

            if (!hm.containsKey(ar.get(i)))
                hm.put(ar.get(i), values[i]);
        } 
        System.out.println(hm);

    }

}