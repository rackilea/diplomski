public class SettingsActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

boolean squareState;
SwitchCompat squareSwitch;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_settings);

        squareSwitch = (SwitchCompat)findViewById(R.id.square_switch); //add this line
        squareSwitch.setOnCheckedChangeListener(this); //Also add this
}

@Override
public void onResume(){
    super.onResume();
    loadPreferences();
    displaySettings();
}

public void loadPreferences(){
    SharedPreferences pref =  getSharedPreferences("settings", AppCompatActivity.MODE_PRIVATE);
    squareState = pref.getBoolean("square_state", true);
}

public void displaySettings(){
    squareSwitch.setChecked(squareState);
}

@Override
public void onPause(){
    super.onPause();
    savePreferences();
}

private void savePreferences(){
    SharedPreferences pref = getSharedPreferences("settings", AppCompatActivity.MODE_PRIVATE);
    SharedPreferences.Editor editor = pref.edit();
    editor.putBoolean("square_state", squareState);
    editor.apply();
}

@Override
public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    int id = buttonView.getId();

    switch(id){
        case R.id.square_switch:
            squareState = isChecked;
            break;
    }
}