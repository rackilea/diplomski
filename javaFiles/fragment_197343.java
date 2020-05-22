public class Preference extends PreferenceActivity implements OnSharedPreferenceChangeListener  {

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    addPreferencesFromResource(R.xml.preferences);
}