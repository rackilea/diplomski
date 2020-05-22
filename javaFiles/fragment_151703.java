public class MainActivity extends AppCompatActivity {

private SharedPreferences preferences;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    SharedPreferences.Editor editor = preferences.edit();
    editor.putString("Status","Success");
    editor.apply();

    getContentResolver().registerContentObserver(ContactsContract.Contacts.CONTENT_URI, true,
            new VolumeCheck(this, new Handler()));
}
}



import android.content.Context;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;


public class VolumeCheck extends ContentObserver {
private final SharedPreferences preferences;

private Context context;

public VolumeCheck(Context c, Handler handler) {
    super(handler); //Creates a new handler
    context = c; //variable context, defined earlier, is set equal to c, context of service.

    preferences = PreferenceManager.getDefaultSharedPreferences(c.getApplicationContext());
    String status = preferences.getString("Status", "");
    if(!status.equalsIgnoreCase(""))
    {
        // got the value read from shared preference
        Log.i("Reading value", status);
    }
}
}