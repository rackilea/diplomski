//Add your packagename here please

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class notescreen extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        // Here is where you call the super on this method.
        // Mostly always comes as first line of any onCreate.
        super.onCreate(savedInstanceState);

        // After you have your layout set, you can retrieve your references
        setContentView(R.layout.notescreen);

        // You have just recovered your view class
        final EditText text = (EditText) findViewById(R.id.title);

        // You have just recovered the text of that view class (text)
        // final String value = text.getText().toString();

        // The log works as a printer on the console
        // Log.d("notescreen", "This is the text: " + value);

        // But hey... there is no text right "onCreate", right?
        // Soo...

        // Retrieve a button (you will need to create it on XML first)
        final Button clickForTextBt = (Button) findViewById(R.id.clickfortextbt);

        // Make that button print your message
        clickForTextBt.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("notescreen", "This is the text: " + text.getText());
            }
        });
    }
}