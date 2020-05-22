public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
final CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);

SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
final SharedPreferences.Editor editor = preferences.edit();
if (preferences.getBoolean("checkbox1", false) == true) {
    checkBox.setChecked(true);
} else {
    checkBox.setChecked(false);

}
checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (checkBox.isChecked()) {
            editor.putBoolean("checkbox1", true);
            editor.apply();
        } else {
            editor.putBoolean("checkbox1", false);
            editor.apply();
        }
    }
});


if (preferences.getBoolean("checkbox2", false) == true) {
    checkBox2.setChecked(true);
} else {
    checkBox2.setChecked(false);

}
checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (checkBox2.isChecked()) {
            editor.putBoolean("checkbox2", true);
            editor.apply();
        } else {
            editor.putBoolean("checkbox2", false);
            editor.apply();
        }
    }
});