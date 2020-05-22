public class MainActivity extends AppCompatActivity {

CheckBox cb_gesdeutsch;
String str_cb_gesdeutsch = "";

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    cb_gesdeutsch = (CheckBox) findViewById(R.id.cb_gesdeutsch);

  }

 public void OnAnghinzu(View view) {
    CheckboxUpload(view);
  }

public void CheckboxUpload(View view) {
    boolean cb_checked = ((CheckBox) cb_gesdeutsch).isChecked();
    if (cb_checked) {
        str_cb_gesdeutsch = "Yes";
        Toast.makeText(MainActivity.this, "Checkbox is checked  " + str_cb_gesdeutsch, Toast.LENGTH_SHORT).show();

    } else {
        str_cb_gesdeutsch = "No";
        Toast.makeText(MainActivity.this, "Checkbox is unchecked  " + str_cb_gesdeutsch, Toast.LENGTH_SHORT).show();

     }
   }
 }