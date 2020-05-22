import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GameFragment extends Fragment {

// All static variables
public static final String URL = "http://api.androidhive.info/pizza/?format=xml";
// XML node keys
static final String KEY_ITEM = "item"; // parent node
static final String KEY_ID = "id";
static final String KEY_NAME = "name";
static final String KEY_COST = "cost";
static final String KEY_DESC = "description";

private static class GetStuffFromUrlTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {
        String url = params[0];
        String xml = "";
        try {
            // defaultHttpClient
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            xml = EntityUtils.toString(httpEntity);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xml;
    }

}

private static class ParseStuffIGotFromSomeWhereTask extends AsyncTask<String, Void, Document> {

    @Override
    protected Document doInBackground(String... params) {

        String stringToParse = params[0];
        Document document = new XMLParser().getDomElement(stringToParse);

        return document;
    }

}

private static class XMLParser {

    public Document getDomElement(String xml){
        Document doc = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder db = dbf.newDocumentBuilder();

            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xml));
            doc = db.parse(is); 

        } catch (ParserConfigurationException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        } catch (SAXException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        } catch (IOException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        }

        return doc;
    }

}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.xyz, container, false);

    //This is the task we use to parse the XML we got back from the getStuffFromUrlTask
    final ParseStuffIGotFromSomeWhereTask parseTask = new ParseStuffIGotFromSomeWhereTask() {

        @Override
        public void onPostExecute(Document document) {
            // here you can access the document that is the result of our parse operation

            //document.getElementsByTagName(XYZ)...

        }

    };

    //This is the task we use to get stuff from the URL
    GetStuffFromUrlTask getStuffFromUrlTask = new GetStuffFromUrlTask() {

        @Override
        public void onPostExecute(String result) {
            //The task has completed, the string result contains the XML data we got from the URL
            parseTask.execute(result); //Now we start the task to parse the xml
        }

    };

    getStuffFromUrlTask.execute(URL);

    return rootView;
}

}