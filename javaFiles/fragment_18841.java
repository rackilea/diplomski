package come.somecompany.somepackage.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WebUtils {

    /**
     * Gets the HTML value of a website and
     * returns as a string value.
     * 
     * @param website website url to get.
     * @param ssl True if website is SSL.
     * @param useragent Specified User-Agent (empty string "" means use system default).
     * @return String value of website.
     */
    public String getHTML(String website, boolean ssl, String useragent) {
        String html = "";
        String temp;
        String prefix;
        if (ssl) {
            prefix = "https://";
        } else {
            prefix = "http://";
        }
        try {
            URL url = new URL(prefix + website);
            URLConnection con = url.openConnection();
        if (!(useragent.equalsIgnoreCase(""))) {
            con.setRequestProperty("User-Agent", useragent);
        }
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        while((temp = in.readLine()) != null) {
            html += temp + "\n";
        }
        in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return html;
    }
}