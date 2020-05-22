import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView; 

 public class MainActivity extends Activity {

 Button btnClick  = null;
TextView txtView = null;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

btnClick = (Button) findViewById(R.id.btnClick);
txtView = (TextView) findViewById(R.id.txtView);

btnClick.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(View v) {
    txtView.setText("MP 204");
    }
});
}

}