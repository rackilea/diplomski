import java.net.HttpURLConnection;

public class GetExternalIp {

    public static void main(String args[]) {
        try {

            java.net.URL url = new java.net.URL(
                    "http://whatismyip.com/automation/n09230945.asp");

            java.net.HttpURLConnection con = (HttpURLConnection) url
                    .openConnection();

            java.io.InputStream stream = con.getInputStream();

            java.io.InputStreamReader reader = new java.io.InputStreamReader(
                    stream);

            java.io.BufferedReader bReader = new java.io.BufferedReader(reader);

            System.out.print("Your IP address is " + bReader.readLine());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}