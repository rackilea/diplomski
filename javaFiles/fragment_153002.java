import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;


public class JsonExample {

    public  static void main(String[] args) {

        String html=null;

        //Descargamos el html
        String url = "http://www.topix.com";
        Connection conn = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36");
        try {
            Response resp = conn.execute();
            if (resp.statusCode() != 200) {
                System.out.println("Error: "+resp.statusCode());
            }else{
                System.out.println(Thread.currentThread().getName()+" is downloading "+ url);
                //html = conn.get().html();
            }   
        }catch(IOException e) {
             System.out.println(e.getStackTrace());
             System.out.println(Thread.currentThread().getName()+"No puedo conectar con  "+ url + e);
             System.out.println("No se puede conectar");
        }
    }   
}