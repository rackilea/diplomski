import org.apache.http.client.fluent.*;
import org.apache.http.entity.ContentType;

public class QuickStart {
    public static void main(String[] args) throws Exception {  
        Executor executor = Executor.newInstance()
                .auth("admin", "geoserver")
                .authPreemptive("172.16.17.86:9090");       
        String response = executor.execute(Request.Put("http://172.16.17.86:9090/geoserver/rest/workspaces/IDIRA6/datastores/scenario2373/external.shp?configure=all")
                .bodyString("E:\\Tomcat\\apache-tomcat-8.5.37\\webapps\\geoserver\\data\\data\\IDIRA6\\scenario2373\\", ContentType.create("text/plain")))
                 .returnResponse()
                 .toString();
         System.out.println(response);
    }
}