import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Links {

    public static void main(String[] args) throws IOException {

        URL pageLocation = new URL("http://horstmann.com/index.html");
        HttpURLConnection urlConnection = (HttpURLConnection) pageLocation.openConnection(); 
        InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        StringBuilder response = new StringBuilder();
        String line;
        while((line = bufferedReader.readLine()) != null) {
            response.append(line);
        }
        bufferedReader.close();

        System.out.println(getHTMLLinksFromPage(response.toString()));
    }

    private static List<String> getHTMLLinksFromPage(final String webPage) {

        List<String> links = new ArrayList<>();

        for(int i = 0; i < webPage.length()-6; i++) {
            if(webPage.charAt(i) == 'h' && webPage.charAt(i+1) == 'r') {
                for(int j = i; j < webPage.length(); j++ ){
                    if(webPage.charAt(j) == '>'){
                        String link = webPage.substring(i+6,j-1);
                        links.add(link);
                        break;
                    }
                }
            }
        }
        return links;
    }
}