import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity
{
    public static boolean PORTRAIT_MODE;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        mContext = this;

        setContentView(R.layout.main);

        PORTRAIT_MODE = (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT    );

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (PORTRAIT_MODE)
                {
                    EditText inputP = (EditText)findViewById(R.id.input_in_main_portrait);
                    Intent  outputActivity;
                            outputActivity = new Intent(mContext, OutputActivity.class);
                            outputActivity.putExtra("numberOfLetters", inputP.getText().toString());
                    startActivity(outputActivity);
                } else
                {
                    EditText inputL  = (EditText)findViewById(R.id.input_in_main_portrait);
                    TextView outputL = (TextView)findViewById(R.id.txvIn_output_fragment);
                    outputL.setText(DoStuff.createOutput(Integer.parseInt(inputL.getText().toString())));
                }
            }
        });
    }
}