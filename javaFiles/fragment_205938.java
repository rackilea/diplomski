public class MyPreferencesActivity extends PreferenceActivity {

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getPreferenceManager().setSharedPreferencesName("sharedPreferencesFilename");
        addPreferencesFromResource(R.xml.prefs);

    }
}