import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class CheckActivity extends AppCompatActivity {

    TextView textView;
    CheckBox cbCs,cbAcc,cbGraphic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checks);

        cbCs = findViewById(R.id.cbCs);
        cbAcc = findViewById(R.id.cbAcc);
        cbGraphic = findViewById(R.id.cbGraphic);

        Button btnapply = findViewById(R.id.btnapply);
        btnapply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               if(!cbCs.isChecked() &&!cbAcc.isChecked() && !cbGraphic.isChecked() ){
                   Toast.makeText(CheckActivity.this, "Select Any",
                           Toast.LENGTH_LONG).show();

               }
                else{
                    StringBuffer result = new StringBuffer();
                result.append("Computer Science check : ").append(cbCs.isChecked());
                result.append("\nAccounting check : ").append(cbAcc.isChecked());
                result.append("\nGraphic check :").append(cbGraphic.isChecked());
                Toast.makeText(CheckActivity.this, result.toString(),
                        Toast.LENGTH_LONG).show();
            }}
        });
    }

}