import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

import org.json.JSONObject;

public class MainActivity extends Activity {

    Button btnSearch;
    String method = "getStations";
    BroadcastReceiver apiListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BroadcastReceiver apiListener = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String output = intent.getStringExtra("API_Response); //Getting the string extra you input earlier in the AsyncTask.
                Toast.makeText(MainActivity.this,"ProcessFinish",Toast.LENGTH_SHORT).show();

                if(output != null){
                    Toast.makeText(MainActivity.this,"not null",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this," null",Toast.LENGTH_SHORT).show();
                }
            }
        };

        //Since you are starting your AsyncTask here, might want to set up the receiver prior to calling the task.
        LocalBroadcastManager.getInstance(this).registerReceiver(apiListener, new IntentFilter(""));

        GetStationsAPICall getStations = new GetStationsAPICall(this);
        new GetStationsAPICall(this).execute(method);
    }

    public void searchClicked(View view){
        Toast.makeText(MainActivity.this,"Search Clicked",Toast.LENGTH_SHORT).show();
    }

    //Registers the receiver whenever this acitivty is currently being shown or about to.
    @Override
    public void onStart() {
        super.onStart();
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(apiListener, new IntentFilter("StationsAPI")); //This is the intent filter this receiver will be listening for
    }

    //This stops the receiver from listening when the activity is no longer shown.
    @Override
    public void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(apiListener);
    }
}