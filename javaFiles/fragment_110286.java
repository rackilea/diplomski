import java.util.ArrayList;
import java.util.List;

public class container {
    private static List<String> data = new ArrayList<String>(); // <-- new was missing

    public static List<String> getData() {
        return data;
    }
    public static void setData(String a) {
        data.add(a);
    }
}