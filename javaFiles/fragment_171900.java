import java.util.Date;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class FacebookResponse {

int id;
String username;
String email;
String link;
Date updated_time;

@Override
public String toString() {
    return "ID: " + id + " username: " + username + " email: " + email + " link: " + link + " updated_time: " + updated_time;
};



/**
 * @param args
 */
public static void main(String[] args) {        
    String json = "{\"id\":\"12345\",\"username\":\"myusername\",\"email\":\"myemail\u0040yahoo.it\",\"link\":\"http://www.facebook.com/mysusername\",\"updated_time\":\"2013-01-04T10:50:26+0000\"}";
    Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();

    FacebookResponse response = gson.fromJson(json, FacebookResponse.class);
    System.out.println(response);
}