public class MainActivity extends Activity {

 public EditText mEdit;
 public RadioButton rButton;
 public RadioGroup rSexGroup;
 public Button but;
 public String str = "";

 @Override
 protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    rSexGroup = (RadioGroup)findViewById(R.id.male_female_custom_choice);
    but= (Button) findViewById(R.id.but);

    but.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            int selectedId = rSexGroup.getCheckedRadioButtonId();
            rButton = (RadioButton)findViewById(selectedId);
            if (rButton.getText().toString().equals("Male")) {
                str = "Male";
            }
            if (rButton.getText().toString().equals("FeMale")) {
                str = "FeMale";
            }
            if (rButton.getText().toString().equals("Custom")) {
                mEdit = (EditText)findViewById(R.id.edit);
                str = mEdit.getText().toString();
            }
            Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
        }
    });
  }
}