import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {

private View mBtn1;
private View mBtn2;
private TextView mTxt;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_layout);

    mBtn1 = findViewById(R.id.button1);
    mBtn2 = findViewById(R.id.button2);
    mTxt = (TextView)findViewById(R.id.textView);

    mBtn1.setOnClickListener(mBtnClickListener);
    mBtn2.setOnClickListener(mBtnClickListener);

}

View.OnClickListener mBtnClickListener = new View.OnClickListener() {

    /**
     * This is all sync because we want to have only one event at a time
     * @param v
     */
    @Override
    public synchronized void onClick(View v) {

        switch (v.getId()) {
            case R.id.button1:
                mTxt.setText("button1");
                break;
            case R.id.button2:
                mTxt.setText("button2");
                break;

        }
        }
    } ;
    }