import android.app.*;
import android.os.*;
import android.util.*;
import java.io.*;
import java.net.*;

public class MainActivity extends Activity 
{
    @Override
     protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        new connection().execute();
    }
}

 class connection extends AsyncTask<String,String,String> {
public static PrintWriter out;
BufferedReader in;
public static boolean running = true;
    @Override
    protected String doInBackground(String... message) {

        try
        {
            InetAddress serverAddr = InetAddress.getByName("localhost");
            Socket socket = new Socket(serverAddr, 8008);
            // send the message to the server
            out = new PrintWriter(new BufferedWriter(
                              new OutputStreamWriter(socket.getOutputStream())), true);

            in = new BufferedReader(new InputStreamReader(
                                    socket.getInputStream()));

        while(running) {
            String msgfromserver = in.readLine();
        }
        }
        catch (Exception e)
        {}

        return null;
    }

    public static void sendmsg(String msg){
        if(out!=null){
            out.println(msg);
            out.flush();
        }
    }
}