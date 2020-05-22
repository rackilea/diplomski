public class SettingsFragment extends AppCompatActivity  {

static CoordinatorLayout coordinatorLayout;
 Activity thisActivity=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SnackbarShow.showSnackbar(thisActivity);

        // Display the fragment as the main content.
        getFragmentManager().beginTransaction().replace(android.R.id.content,
                new PrefsFragment()).commit();
        ActionBar bar = getSupportActionBar();
       bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4CAF50")));


    }

    public static class PrefsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            addPreferencesFromResource(R.xml.settings);


            Preference save_database = findPreference("savedatabase");
            save_database.setOnPreferenceClickListener( new Preference.OnPreferenceClickListener()
            {
                public boolean onPreferenceClick( Preference pref )
                {
                    Data.bdd.Save_database(getActivity(),getView());
                    return true;
                }
            } );


            final CheckBoxPreference checkboxPref = (CheckBoxPreference) getPreferenceManager().findPreference("checkbox_always_on");
            checkboxPref.
                    setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {

                        public boolean onPreferenceChange(Preference preference, Object newValue) {
                            if (newValue.toString().equals("true")) {
                                Screen.screen_on(getActivity());
                                showSnackbar(getView());
                            } else {
                                Screen.screen_off(getActivity());
                                showSnackbar(getView());
                            }
                            return true;
                        }
                    });
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = super.onCreateView(inflater, container, savedInstanceState);

            view.setBackgroundColor(getResources().getColor(R.color.green_800));

            return view;
        }


        public static void showSnackbar(View view) {
            Snackbar snackbar = Snackbar
                    .make(view, "There is one text", Snackbar.LENGTH_LONG)
                    .setAction("Action Text", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.v("snackbar","yoo clicked action");
                        }
                    });

            // Changing message text color
            snackbar.setActionTextColor(Color.RED);

            // Changing action button text color
            View sbView = snackbar.getView();
            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.YELLOW);

            snackbar.show();
        }
    }