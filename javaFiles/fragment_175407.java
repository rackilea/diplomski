import android.preference.EditTextPreference;

public class Settings extends PreferenceActivity {


    EditTextPreference weightEditTextPreference;
    EditTextPreference ageEditTextPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

        weightEditTextPreference = (EditTextPreference)findPreference("weight");
        ageEditTextPreference = (EditTextPreference)findPreference("age");

        SharedPreferences getWeightAndAgeStore = getSharedPreferences("weightAndAgeStorage", Context.MODE_PRIVATE);
        weightEditTextPreference.setText(getWeightAndAgeStore.getString("weight", "0"));
        ageEditTextPreference.setText(getWeightAndAgeStore.getString("age", "0"));