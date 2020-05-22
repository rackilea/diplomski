public class WifiParser  {

public static Vector<WifiDescription> parse(InputStream file) {
    Vector<WifiDescription> wifiDescription = new Vector<WifiDescription>();
    Log.d("XML", "test Parsage");
    try {
        // create a XMLReader from SAXParser
        XMLReader xmlReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        Log.e("XML", "xmlReader");
        WifiHandler wifiHandler = new WifiHandler();
        Log.e("XML", "WifiHandler");
        xmlReader.setContentHandler(wifiHandler);
        Log.e("XML", "setContentHandler");
        xmlReader.parse(new InputSource(file));
        Log.e("XML", "parse");
        wifiDescription = wifiHandler.getWifiDescription();
        Log.e("XML", "wifi description");           
    } 

    catch(Exception ex) {
        Log.d("XML ex.getMessage", "" + ex.getMessage());
        ex.printStackTrace();

        Log.d("XML", "WifiParser: parse() failed");
    }

    return wifiDescription;
}