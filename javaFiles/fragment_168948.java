import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // instantiate mPlatesList
        ArrayList<HashMap<String, String>> mPlatesList = new ArrayList<HashMap<String, String>>();

        // fill it with 3 HashMaps
        mPlatesList.add(new HashMap<String, String>());
        mPlatesList.add(new HashMap<String, String>());
        mPlatesList.add(new HashMap<String, String>());

        // put some values in the 3 HashMaps
        mPlatesList.get(0).put("Key1", "Value1");
        mPlatesList.get(0).put("Key2", "Value2");
        mPlatesList.get(1).put("Key3", "Value3");
        mPlatesList.get(2).put("Key4", "Value4");

        // build the table from mPlatesList
        Set<String> unionSet = new HashSet<String>();
        for (HashMap<String, String> hashMap : mPlatesList) {
            unionSet.addAll(hashMap.values());
        }
        String[] table = unionSet.toArray(new String[unionSet.size()]);

        // print the table
        for(int i=0; i<table.length; i++)
            System.out.println(table[i]);

    }

}