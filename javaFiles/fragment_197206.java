import android.os.Handler;
import android.os.Message;

public class GetData extends Thread
{

    // Holds url that data is stored on
    private URL url

    // Sets the url value
    public GetData(URL newUrl)
    {
         url = newUrl;
    }

    // Runs when the thread is launched
    public void run()
    {
        // Opens connection
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // Sends back to UI using a Message
        Message msg = MainActivity.MainActivityInterface.obtainMessage(MainActivity.getAndUpdate);
        msg.obj = con.getContentLength(); // Adds the data
        HomeScreen.homeScreenInterface.sendMessage(msg); 
    }
}