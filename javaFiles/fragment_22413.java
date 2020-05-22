import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
//import android.preference.PreferenceManager;
import android.widget.TextView;

public class pref extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Context mContext = this.getApplicationContext();
        SharedPreferences prefs = mContext.getSharedPreferences("pref", 0);
        String c = prefs.getString("c", "hello");
        TextView t = (TextView)findViewById(R.id.te);
        t.append(c);

        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("c", "There");
        edit.commit();
    }
}