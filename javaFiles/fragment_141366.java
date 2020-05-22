import java.net.URLEncoder;
 try {
     URLEncoder.encode(YOUR_URL_HERE, "UTF-8")
 } catch (UnsupportedEncodingException e) {
     e.printStackTrace();  
 }