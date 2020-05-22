import java.net.URLConnection;
import java.net.URL;
import java.io.InputStreamReader;

class BingJson{

  JSONObject getJSONfromBing(String term){
  try{
    URLConnection c = new URL(term).openConnection();
    String key = (DatatypeConverter.printBase64Binary(("XXX" + ":" + "XXX").getBytes("UTF-8")));
    c.setRequestProperty("Authorization", String.format("Basic %s",key));
    c.connect();
    //etc.
  }
}