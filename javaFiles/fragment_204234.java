import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class GetURL extends Activity {
    private Button goButton;
    String url = "http://www.yahoo.com";
    Intent i = new Intent(Intent.ACTION_VIEW);
    Uri u = Uri.parse(url);
    Context context = this;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        goButton = (Button)findViewById(R.id.goButton);
        goButton.setOnClickListener(new OnClickListener() {         
            @Override
            public void onClick(View v){
                try {
                      // Start the activity
                        i.setData(u);
                      startActivity(i);
                    } catch (ActivityNotFoundException e) {
                      // Raise on activity not found
                      Toast.makeText(context, "Browser not found.", Toast.LENGTH_SHORT);
                    }
                  } 
        });
    }
}