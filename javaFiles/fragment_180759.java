import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadWithCookieExample
{
    public static void main(String[] arguments)
    {
        try
        {
            URL url = new URL("...");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Cookie", "blabla"); // Hard-coded correct cookie value
            String readStream = readStream(con.getInputStream());
            System.out.println(readStream);
        } catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private static String readStream(InputStream inputStream) throws IOException
    {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }
        }
        return stringBuilder.toString().trim();
    }
}