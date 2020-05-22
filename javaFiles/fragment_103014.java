import java.io.BufferedWriter;
import java.io.FileWriter;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.client.params.CookiePolicy;

  public class Test {

     public static final String TARGET_HTTPS_SERVER = "www.example.net"; 
     public static final int    TARGET_HTTPS_PORT   = 443; 

     public static void main(String[] args) throws Exception {

         HttpClient httpClient = new HttpClient();
         httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);

         PostMethod post = new PostMethod("https://www.example.com/login.html");
         post.setRequestHeader(new Header(
                 "User-Agent", "Mozilla/5.0 /Windows; U; Windows NT 4.1; de; rv:1.9.1.5) Gecko/20091102 Firefox/3.0"));

         post.addParameter("login", "true");
         post.addParameter("username", "xxx");
         post.addParameter("password", "xxx");
         post.addParameter("language", "de");
         httpClient.executeMethod(post);


         System.out.println(post.getResponseBodyAsString());
         String body=post.getResponseBodyAsString();
//Get the session id by parsing the code, i know this is not pretty
             String sessionid=body.substring(body.indexOf("session")+10,body.indexOf("session")+10+14);
             System.out.print(sessionid);


             GetMethod get=new GetMethod("https://www.example.com/thesiteyouwannabrowse?sessionid="+sessionid);

         get.setRequestHeader(new Header(
             "User-Agent", "Mozilla/5.0 /Windows; U; Windows NT 4.1; de; rv:1.9.1.5) Gecko/20091102 Firefox/3.0"));
         httpClient.executeMethod(get);

         System.out.println(get.getResponseBodyAsString());
         //write it into a file
         try{
                // Create file 
                FileWriter fstream = new FileWriter("file.html");
                    BufferedWriter out = new BufferedWriter(fstream);
                out.write(get.getResponseBodyAsString());
                //Close the output stream
                out.close();
                }catch (Exception e){//Catch exception if any
                  System.err.println("Error: " + e.getMessage());
             }     
         post.releaseConnection();
     }
  }