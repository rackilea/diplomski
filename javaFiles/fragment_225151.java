package geekdashboard.learningtetsing;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "PROFILE_CHANGER_KEYWORDS";
    public static final String PREFS_KEY = "silent";
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toastTesting(View v) {

        // Code for Toast
        Toast.makeText(MainActivity.this,
                "Toast is Working :)", Toast.LENGTH_SHORT).show();
        // Toast End
    }


    public void savingValue(View view) {
        // Reading value from name editField
        EditText nameField = (EditText) findViewById(R.id.name);
        String enteredName = nameField.getText().toString();

        if (enteredName.equals("")) {
            Toast.makeText(MainActivity.this,
                    "Empty Keyword Not Allowed", Toast.LENGTH_SHORT).show();
        } else {

           // Context context = getActivity();
            SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);

            //prefs.edit().putString(PREFS_KEY, enteredName).commit();

            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString(PREFS_KEY, enteredName);
            editor.commit();


            Toast.makeText(MainActivity.this,
                    enteredName + " has been saved to " + PREFS_NAME, Toast.LENGTH_SHORT).show();
        }
    }

    public void showValue(View sv) {

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
       String defaultValue = "Silent";
        String savedValue = sharedPref.getString(PREFS_KEY, defaultValue);

        /* SharedPreferences prefsread = this.getSharedPreferences(
                "com.geekdashboard.learningtetsing", Context.MODE_PRIVATE);
        String savedValue = prefsread.getString(PREFS_KEY, null); */
        Toast.makeText(MainActivity.this,
                savedValue + " is the last saved value in "+ PREFS_NAME, Toast.LENGTH_SHORT).show();
    }


}