import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TestButton extends Activity {

    Context ctx = null;
    Button btn = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttonbackground);

        ctx = getApplication();

        btn = (Button) findViewById(R.id.switch_left);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               Toast.makeText(ctx, "Button clicked", 5000).show();
               // Log.w(this.getClass().getName(), "clicked left arrow");
            }
        });
    }
}