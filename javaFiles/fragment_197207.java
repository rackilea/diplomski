import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import android.os.Handler;
import android.os.Message;

public class MainActivity extends Activity {

    // Holds activity instance
    public static MainActivity currentInstance;

    // Variable that allows us to separate messages for handler
    public static final getAndUpdate = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentInstance = this;
        TextView mTextView = (TextView) findViewById(R.id.hello);

        try 
        {
            URL mUrl = new URL("http://192.168.1.53:8080/some.zip");

            // Spawns worker thread
            GetData gd = new GetData(mUrl);
            gd.start();
        } 
        catch (Exception e) 
        {
            mTextView.setText("ERROR: " + e.getMessage());
        }
    }

    // Deals with service responses
    public static Handler MainActivityInterface = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            switch(msg.what)
            {
                case getAndUpdate:
                    currentInstance.mTextView.setText((String) msg.obj); // Gets message object and updates UI
                break;
            }
        }
    }
}