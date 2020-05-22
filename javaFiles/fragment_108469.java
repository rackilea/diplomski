import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TableEg extends Activity{
  Hashmap<Integer, ArrayList<String>> hashMap = new Hashmap<Integer, ArrayList<String>>();

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    int count = 0;
    String html = "<table><tr><td>1</td><td>Some Value</td><td>Some Other Value</td><td>Yet another value</td></tr></table>";

    try {
     Document doc = Jsoup.parse(html);
     Elements tableElements = doc.select("table");
     Elements tableRowElements = tableElements.select(":not(thead) tr");

     for (int i = 0; i < tableRowElements.size(); i++) {
        Element row = tableRowElements.get(i);
        ArrayList<String> arrayList = new ArrayList<String>();
        Elements rowItems = row.select("td");
        for (int j = 0; j < rowItems.size(); j++) {
           arrayList.add(rowItems.get(j).text());
        }
        hashMap.put(Integer.valueOf(count), arrayList);
        count++;
     }

     } catch (IOException e) {
        e.printStackTrace();
     }
  }
  }