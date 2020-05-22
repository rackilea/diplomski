import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;


public class URLReader {
    public static void main(String[] args) throws Exception {

        //System.out.println(Cipher.getMaxAllowedKeyLength("AES"));

        //Create HttpURLConnection  
        HttpURLConnection httpcon = (HttpURLConnection) new URL("https://img.shields.io/sourceforge/dt/xr3player.svg").openConnection();
        httpcon.addRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));

        //Read line by line
        String line = "" , inputLine;
        while ( ( inputLine = in.readLine() ) != null) {
            line += "\n" + inputLine;
            System.out.println(inputLine);
        }
        in.close();

        //Get SourceForge Downloads 
        System.out.println("Total Downlads: "+line.split("<text x=\"98.5\" y=\"14\">")[1].split("/total")[0]);
    }

}