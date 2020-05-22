package hello;

    import org.springframework.http.HttpHeaders;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.net.HttpURLConnection;
    import java.net.URL;
    import java.util.Base64;


    public class Application {

        public static void main(String args[]) throws IOException {
            String url = "https://my-jira-domain.atlassian.net/rest/api/2/issue/MOON-13";
            URL obj = new URL(url);

            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            //Setting the Request Method header as GET
            con.setRequestMethod("GET");

            //Prepairing credentials
            String cred = "my@jira.com:mypassword";
            byte[] encoded = Base64.getEncoder().encode(cred.getBytes());
            String credentials = new String(encoded);

            //Setting the Authorization Header as 'Basic' with the given credentials
            con.setRequestProperty("Authorization", "Basic " + credentials);

            //Setting the User-Agent header
            con.setRequestProperty("User-Agent", HttpHeaders.USER_AGENT);

            int responseCode = con.getResponseCode();

            //reading the return
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream())
            );
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String result = response.toString();
        }
    }