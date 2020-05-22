import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class OutputActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        String s = i.getStringExtra("numberOfLetters");
        Log.w("OutputActivity=====", "`````TRYING to be Displaying " + s + " letters in what? Portrait? " + MainActivity.PORTRAIT_MODE);

        setContentView(R.layout.output_fragment);

        TextView et = (TextView) findViewById(R.id.txvIn_output_fragment);
        et.setText(DoStuff.createOutput(Integer.parseInt(s)));
    }
}