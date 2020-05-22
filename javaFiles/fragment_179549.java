import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


protected void onPostExecute(String results) {
        if (results != null) {
        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            InputSource s = new InputSource(new StringReader(result));
            Document doc = dBuilder.parse(s);
            doc.getDocumentElement().normalize();
                            //EditText et = (EditText) findViewById(R.id.my_edit);
                            TextView tv = (TextView) findViewById(R.id.Date);
                            tv.setText("sunrise at "+doc.getElementsByTagName("sunrise").item(0).getTextContent() + " sunset at "+doc.getElementsByTagName("sunset").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    Button b = (Button) findViewById(R.id.my_button);
    b.setClickable(true);
    }