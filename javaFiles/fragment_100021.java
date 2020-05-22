//Classes to import
import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;


//Shortening download URL
URL url=new URL("http://goo.gl/api/shorten");
HTTPRequest req=new HTTPRequest(url,HTTPMethod.POST);                               
req.setPayload(("url=www.google.com").getBytes());

URLFetchService  service = URLFetchServiceFactory.getURLFetchService(); 
HTTPResponse response = service.fetch(req); 
byte[] content = response.getContent(); 
String urlshort=new String(content);   //here is the JSON data from goo.gl