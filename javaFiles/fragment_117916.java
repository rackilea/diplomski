import java.util.List;
import com.google.gson.Gson;
public class GsonTest {

public static class Data {
    private List<String> title;
    public List<String> getTitle() {return title;}
    public Data() {}
}

public static void main (String [] args) {
    Gson gson = new Gson();
    Data data = gson.fromJson("{\"title\":[\"1\",\"2\"]}", Data.class);
    System.out.println(data.getTitle());
} 
}