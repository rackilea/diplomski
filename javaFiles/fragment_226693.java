public class MyPrefrence extends PreferenceActivity {

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


    getFragmentManager().beginTransaction()
            .replace(android.R.id.content, new MyPreferenceFragment())
            .commit();

}

public static class MyPreferenceFragment extends PreferenceFragment {
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}

}