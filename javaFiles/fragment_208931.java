import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    public  static String selectedItemInSpinner="";
    Spinner spinner;
    public static EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Drop Down List Selction of Token
         spinner = (Spinner) findViewById(R.id.token_spinner);
        editText = (EditText) findViewById(R.id.editText_order);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.plan_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new TokenSpinner());
        editText.setText(selectedItemInSpinner);
    }}