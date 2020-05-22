public class Preference extends PreferenceFragment implements OnSharedPreferenceChangeListener  {

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    addPreferencesFromResource(R.xml.preferences);
}