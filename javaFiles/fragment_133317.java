import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlayWithGson2 {
    public static void main(String[] args) throws IOException {
        PlayWithGson pwg = new PlayWithGson();

        List<String> headings = new ArrayList<String>();
        headings.add("Vendor Order Id");

        List<List<String>> log = new ArrayList<List<String>>();
        UploadLog ul = new UploadLog("headings", headings, log);

        Gson gson = new Gson();
        String toJson = gson.toJson(ul);
        System.out.println(toJson);
    }
}