import java.util.*;
import java.util.Map.Entry;
import java.util.ArrayList;
public class TestApp {
    private ArrayList<String[]> current_map = new ArrayList<String[]>();
    public TestApp() {
        current_map.add(new String[] { "0","0","0" });
        current_map.add(new String[] { "0","Q","0" });
        current_map.add(new String[] { "0","0","0" });
    }
    public String getValue(int X,int Y){
        return current_map.get(Y)[X]; // for example, getValue(2,2), should give "Q"
    }

    public static void main(String[] args) {
      TestApp ta = new TestApp();
      System.out.println(ta.getValue(1, 1));
    }

}