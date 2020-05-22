public class PairActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragment = new SettingsFragment();
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, fragment)
                .commit();
        ...
    }


    public static class SettingsFragment extends PreferenceFragment {
        public void displayBeans(Collection<Bean> beans) {
            ...
            for(Bean bean : beans) {
                Preference pref = new Preference(getActivity());
                pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                    @Override
                    public boolean onPreferenceClick(Preference preference) {
                        PairActivity pairActivity = (PairActivity) getActivity();
                        // Do something with pairActivity instance
                    }
                });
            }
        }
    }

    ...
}