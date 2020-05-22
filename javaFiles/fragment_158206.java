import com.google.gson.Gson;

public class GSONTest {

    public String value;

    public static void main(String[] args) {
        Gson g = new Gson();
        GSONTest gt = new GSONTest();
        gt.value = "This is a \"test\" of quoted strings";
        System.out.println("String: " + gt.value);
        System.out.println("JSON: " + g.toJson(gt));
    }
}