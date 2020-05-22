import org.json.JSONArray;
import java.util.ArrayList;
import java.util.HashMap;

public class T {
    static String refactor(String jsonData) {
        JSONArray array = new JSONArray(jsonData);

        // find longest array in original container
        JSONArray longest = null;
        for (int i=0; i<array.length(); i++) {
            JSONArray a = array.getJSONArray(i);
            if (longest == null || a.length() > longest.length()) {
                longest = a;
            }
        }

        // build a map with the people in "longest", for quick lookup
        HashMap<String, Integer> bosses = new HashMap<String, Integer>();
        for (int i=0; i<longest.length(); i+=2) {
            bosses.put(longest.getString(i) + "|" + longest.getString(i+1), i);
        }

        // prepare target container       
        ArrayList<JSONArray> container = new ArrayList<JSONArray>();

        // fill in missing values
        for (int i=0; i<array.length(); i++) {
            JSONArray a = array.getJSONArray(i);
            ArrayList<String> refactored = new ArrayList<String>();
            // copy leaf employee
            refactored.add(a.getString(0));
            refactored.add(a.getString(1));
            for (int j=2; j<a.length(); j+=2) {
                // possibly fill in nulls before adding this boss
                String boss = a.getString(j) + "|" + a.getString(j+1);
                if (bosses.containsKey(boss)) {
                    for (int k=j; k<bosses.get(boss); k++) {
                        // pad with nulls until we reach target position
                        refactored.add(null);
                    }
                }
                refactored.add(a.getString(j));
                refactored.add(a.getString(j+1));
            }
            container.add(new JSONArray(refactored));
        }
        return new JSONArray(container).toString();
    }

    public static void main(String args[]) {
        System.out.println(refactor(args[0]));
    }
}