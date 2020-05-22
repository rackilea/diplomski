import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import org.w3c.dom.Document;


public class updater {
public static void main(String[] args) throws IOException {
    try{
        DefaultHttpClient httpclient = ClientMaker();
        HttpGet get = new HttpGet("http://encorpops04:8080/Updater-test/Version.xml");
        HttpResponse response = httpclient.execute(get);
        InputStream in = response.getEntity().getContent();

        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document doc = builder.parse(in);

        //Parse the Xml.
        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        XPathExpression expr = xpath.compile("//version/number/text()");
        String result = (String) expr.evaluate(doc, XPathConstants.STRING);
        System.out.println(result);

        File f = new File(System.getProperty("user.dir")+ "\\Version.xml");
        in = new FileInputStream(f) ;
        doc = builder.parse(in);
        expr=xpath.compile("//version/number/text()");
        String result2 = (String) expr.evaluate(doc, XPathConstants.STRING);
        System.out.println(result2);


        if(Double.parseDouble(result2) < Double.parseDouble(result)){
            HttpGet get2 = new HttpGet("http://encorpops04:8080/Updater-test/MyOutput.jar"); 
            HttpResponse response2 = httpclient.execute(get2);
            InputStream in2 = response2.getEntity().getContent();
            File f2 = new File("MyOutput.jar");
            OutputStream fos = new FileOutputStream(f2);
            byte buf[] = new byte[1024];
            int len;
            while ((len = in2.read(buf)) > 0) {
                fos.write(buf, 0, len);
            }
            fos.close();
            in.close();
        }
        System.out.println("cmd.exe /C  javaw -jar"  +System.getProperty("user.dir") + "\\MyOutput.jar");
        Process p = Runtime.getRuntime().exec("cmd.exe /C  javaw -jar "  +System.getProperty("user.dir") + "\\MyOutput.jar");
        p.waitFor();
        p.destroy();
    }catch(Exception e){ e.printStackTrace(); }


}

public static DefaultHttpClient ClientMaker() {
    int connectiontimeout = 30000; // 1 second int sockettimeout = 1000;
    HttpParams httpparameters = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(httpparameters,
            connectiontimeout);
    HttpConnectionParams.setSoTimeout(httpparameters, connectiontimeout);
    DefaultHttpClient httpclient = new DefaultHttpClient(httpparameters);
    return httpclient;
}

}