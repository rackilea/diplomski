private static final String MY_SHARED_PREFERENCES = "SharedPreferences";
private static final String MY_BUTTON_PREF = "button1";

private SharedPreferences preferences;
private ToggleButton toggleButton;


@Override
protected void onCreate(Bundle, savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.your_activity);

    preferences = getSharedPreferences(MY_SHARED_PREFERENCES, MODE_PRIVATE);

    toggleButton = findViewById(R.id.toggleButton);

    toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(MY_BUTTON_PREF, isChecked);
            editor.commit();

            if(isChecked){
                soundPool.play(sound1, 1, 1, 0, 0, 1);
            }
        }
    });
}

@Override
public void onResume(){
    super.onResume();

    boolean flag = preferences.getBoolean(MY_BUTTON_PREF, false);
    toggleButton.setChecked(flag);
}