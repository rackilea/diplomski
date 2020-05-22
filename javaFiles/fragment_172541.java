import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private Switch swt1;
    private Switch swt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swt1 = (Switch)findViewById(R.id.swt1);
        swt2 = (Switch)findViewById(R.id.swt2);


        swt1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b == true)
                    swt2.setChecked(false);
                else
                    swt2.setChecked(true);
            }
        });

        swt2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b == true)
                    swt1.setChecked(false);
                else
                    swt1.setChecked(true);
            }
        });
    }
}