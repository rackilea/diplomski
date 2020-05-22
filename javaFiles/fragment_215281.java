import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Easy extends Activity {

    EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.easy);
        display = (EditText)findViewById(R.id.displayText);
        display.setText("?");

    }

    static boolean isEmpty = true;

    public void num_Clicked(View v){
        Button btn = (Button) v;

        if (v.getId()== R.id.del_button){
            String s = display.getText().toString();
            s = s.substring(0, s.length() - 1);
            display.setText(s);
            return;
        }

        if(isEmpty){
            display.setText(btn.getText());
            isEmpty = false;
        }
        else{
            display.append(btn.getText().toString()); 
        }
    }
}