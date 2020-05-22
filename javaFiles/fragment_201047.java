import org.json.JSONException;
import org.json.JSONML;
import org.json.JSONObject;
import org.json.XML;

public class JsonToXml {
    public static void main(String[] args) throws JSONException {

        String originalXML = "<?xml version=\"1.0\"?><a t=\"tt\"><b><c>1</c><c>2</c></b></a>";
        System.out.println("oringinal XML:" + originalXML);
        JSONObject jsonConvertByXML = XML.toJSONObject(originalXML);
        System.out.println("jsonConvertByXML:" + jsonConvertByXML);

        String xmlConvertedBackByXML = XML.toString(jsonConvertByXML);
        System.out.println("xmlConvertedBackByXML:" + xmlConvertedBackByXML);

        JSONObject jsonConvertByJSONML = JSONML.toJSONObject(originalXML);
        System.out.println(jsonConvertByJSONML);
        String xmlConvertedBackByJSONML = JSONML.toString(jsonConvertByJSONML);
        System.out.println("xmlConvertedBackByJSONML:" + xmlConvertedBackByJSONML);
    }
}