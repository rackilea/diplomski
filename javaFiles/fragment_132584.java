public class MyPrefs extends PreferenceActivity {

    public static class MyPreferenceFragment extends PreferenceFragment
    {
        @Override
        public void onCreate(final Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);


            Preference pref;
            pref = findPreference("pref_gps_updates");

            pref.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    return true;
                }
            });
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyPreferenceFragment frag =  new MyPreferenceFragment();

        getFragmentManager().beginTransaction().replace(android.R.id.content, frag).commit();

    }
}