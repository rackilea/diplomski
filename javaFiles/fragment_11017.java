package test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLReader {
    public static void main(String[] args) throws Exception {
        System.out.println(function("https://www.nasdaq.com/fr/symbol/ndaq/real-time"));
        System.out.println(function("https://www.nasdaq.com/fr/symbol/ndaq/stock-chart"));
    }

    public static String function(String pURL) throws IOException {
        URL lURL = new URL(pURL);
        BufferedReader lIn = new BufferedReader(
        new InputStreamReader(lURL.openStream()));

        String lInputLine;
        StringBuilder lBuilder = new StringBuilder();
        while ((lInputLine = lIn.readLine()) != null)
            lBuilder.append(lInputLine);
        lIn.close();
        return lBuilder.toString();
    }
}