public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    private static final String CHECKBOX__STATE = "CHECKBOX__SAVE_STATE";

    private Switch checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkbox = findViewById(R.id.checkbox);

        final boolean isChecked;
        if (savedInstanceState != null) {
            isChecked = savedInstanceState.getBoolean(CHECKBOX__STATE);
        } else {
            isChecked = PreferenceManager.getDefaultSharedPreferences(this)
                    .getBoolean(CHECKBOX__STATE, false);
        }

        // Setting the state (if any) of the Switch.
        checkbox.setChecked(isChecked);

        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Log.d(TAG, "onCheckedChanged: isChecked = true - log location");
                } else {
                    Log.d(TAG, "onCheckedChanged: isChecked = false - stop logging location");
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(CHECKBOX__STATE, checkbox.isChecked());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PreferenceManager.getDefaultSharedPreferences(this)
                .edit()
                .putBoolean(CHECKBOX__STATE, checkbox.isChecked())
                .apply();
    }
}