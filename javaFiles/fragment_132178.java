public class TestPrefActivity extends PreferenceActivity implements onSharedPreferenceChangeListener {

    public SwitchPreference testPref;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.sample);

        testPref = (SwitchPreference) findPreference("test"); //Preference Key
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals("test")) {
        boolean test = sharedPreferences.getBoolean("test", false);
        //Do whatever you want here. This is an example.
        if (test) {
            testPref.setSummary("Enabled");
        } else {
            testPref.setSummary("Disabled");
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(TestPrefActivity.this);
        boolean test = preferences.getBoolean("test", false);

        if (test) {
            testPref.setSummary("Enabled");
        } else {
            testPref.setSummary("Disabled");
        }
    }
}