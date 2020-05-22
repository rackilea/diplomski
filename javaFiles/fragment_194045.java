package com.src.main.service;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
public class UserService {
public static final String BASE_URI = "http://localhost:8088/my_webservice/user";
public static final String PATH_VALID_USER = "/UserLogin/validUser/";
public UserService(){
   try{
   HttpContext  context = new BasicHttpContext();
   HttpClient client = new DefaultHttpClient();
   client.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.RFC_2109);  
   URI uri=new URIBuilder(BASE_URI+PATH_VALID_USER).build();    
   HttpGet request = new HttpGet(uri);  
   HttpResponse response = client.execute(request,context); 
   System.err.println("content type : \n"+EntityUtils.toString(response.getEntity()));  
   }catch(ClientProtocolException exception){
   System.err.println("Client Exception: \n"+exception.getStackTrace());    
   }catch(IOException ioException){
     System.err.println("ioException :\n"+ioException.getStackTrace());
   }catch(URISyntaxException exception){
      System.err.println("URI Syntax exxceptin :"+exception.getStackTrace());
   }        
}