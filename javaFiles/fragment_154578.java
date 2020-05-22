import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton = (Button) findViewById(R.id.submitAnswer);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitButton.setText(String.valueOf(score));
            }
        });
    }

    public void checkBoxes(View view) {

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        boolean hasCheckBox1 = checkBox1.isChecked();

        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        boolean hasCheckBox2 = checkBox2.isChecked();

        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()){
            case R.id.checkBox1:
                Toast.makeText(this, "Hooray!Your answer is right", Toast.LENGTH_SHORT).show();
               score ++;
                break;
            case R.id.checkBox2:
                Toast.makeText(this,"Sorry, try again!", Toast.LENGTH_SHORT).show();
                score --;
                break;
        }
        //submitButton.setText(String.valueOf(score));
    }
}