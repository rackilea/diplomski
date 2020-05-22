import org.apache.http.protocol.HTTP;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class start extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       try {
        Document doc = Jsoup.connect(URL).get();
        Log.i("DOC", doc.toString().toString());
    Elements elementsHtml = doc.getElementById(id);
        for(Element element: elementsHtml)
        {
            Log.i("ELEMENTI",URLDecoder.decode(element.text(), HTTP.UTF_8));
        }

    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }