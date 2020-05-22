import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Bookmark> arrayList = new ArrayList<>();
    XmlPullParserFactory pullParserFactory;

    RecyclerView myRecyclerView;
    DataAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = findViewById(R.id.myRecyclerView);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.setHasFixedSize(true);
        try {
            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();

            InputStream in_s = getApplicationContext().getAssets().open("bookmark.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in_s, null);

            parseXML(parser);

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < arrayList.size(); i++) {
            Log.e("OUTPUT", arrayList.get(i).toString());
        }

        dataAdapter = new DataAdapter(this, arrayList);
        myRecyclerView.setAdapter(dataAdapter);
    }

    private void parseXML(XmlPullParser parser) throws XmlPullParserException, IOException {
        ArrayList<Bookmark> countries = null;
        int eventType = parser.getEventType();
        Bookmark country = null;

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String name;
            name = parser.getName();
            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    countries = new ArrayList();
                    break;
                case XmlPullParser.START_TAG:
                    break;

                case XmlPullParser.END_TAG:
                    if (name.equals("Bookmark")) {
                        Log.e("VALUE", parser.getAttributeValue(null, "name") + "");
                        Log.e("VALUE", parser.getAttributeValue(null, "icon") + "");
                        Log.e("VALUE", parser.getAttributeValue(null, "id") + "");
                        Log.e("VALUE", parser.getAttributeValue(null, "searchUrl") + "");
                        Log.e("VALUE", parser.getAttributeValue(null, "nativeUrl") + "");

                        Bookmark bookmark = new Bookmark();
                        bookmark.setName(parser.getAttributeValue(null, "name"));
                        bookmark.setIcon(parser.getAttributeValue(null, "icon"));
                        bookmark.setId(parser.getAttributeValue(null, "id"));
                        bookmark.setSearchUrl(parser.getAttributeValue(null, "searchUrl"));
                        bookmark.setNativeUrl(parser.getAttributeValue(null, "nativeUrl"));
                        arrayList.add(bookmark);
                    }
                    break;
            }
            eventType = parser.next();
        }


    }

    private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException {
        int eventType = parser.getEventType();
        Bookmark bookmark = null;


    }
}