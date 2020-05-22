import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TestActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    Button button1, button2, button3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    public void onClick(View v) {
        //figure out which button was pressed:
        switch (v.getId()) {
        case R.id.button1:
            //do button1 actions
            break;
        case R.id.button2:
            //do button2 actions
            break;
        case R.id.button3:
            //do button3 actions
            break;
       }
    }
}