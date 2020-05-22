public class MainActivity extends Activity {
    Switch[] buttons;
    int numberOfButtons = 5;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        buttons = new Switch[numberOfButtons];
        sharedPreferences = getSharedPreferences("YourPreferenceName", MODE_PRIVATE);

        for (int i = 0; i < numberOfButtons; i++) {
            buttons[i] = findViewById(getResources().getIdentifier("switchButton" + String.valueOf(i + 1), "id", getPackageName()));
        }
    }

    public void onPause() {
        super.onPause();
        for (int i = 0; i < numberOfButtons; i++) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(String.valueOf(i + 1), buttons[i].isChecked());
            editor.apply();
        }
    }

    public void onResume(){
        super.onResume();
        for (int i = 0; i < numberOfButtons; i++) {
            buttons[i].setChecked(sharedPreferences.getBoolean(String.valueOf(i + 1), false));
        }
    }
}