public class FragmentSettingsPage extends FragmentPage {

    // Preferences
    public static final String PREFS_NAME = "Preferences";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(inflater, container);

        SharedPreferences preferences = mainActivity.getSharedPreferences(PREFS_NAME, 0);
        // do some other top secret stuff here ;)


        return rootView;
    }
}