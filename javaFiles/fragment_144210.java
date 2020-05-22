class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        setupActionBar()

        if (savedInstanceState == null)
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.frame, SettingsFragment.newInstance())
                    .commit()
    }

    private fun setupActionBar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    class SettingsFragment : PreferenceFragmentCompat() {

        override fun onActivityCreated(savedInstanceState: Bundle?) {
            super.onActivityCreated(savedInstanceState)

            val actionBar = (activity as AppCompatActivity).supportActionBar

            actionBar?.title = preferenceScreen.title
        }

        override fun onCreatePreferences(bundle: Bundle?, rootKey: String?) {

            // Using this method instead of addPreferencesFromXml so we can specify the root preference screen
            // This way, navigating to a new screen is as simple as calling SettingsFragment.newInstance("new_root")
            setPreferencesFromResource(R.xml.prefs, rootKey)
        }

        companion object {

            fun newInstance(rootKey: String = "root") = SettingsFragment().apply {

                // When you pass a string argument with key ARG_PREFERENCE_ROOT, 
                // PreferenceFragmentCompat picks it up and supplies it as an argument to onCreatePreferences
                arguments = Bundle().apply { putString(ARG_PREFERENCE_ROOT, rootKey) }
            }
        }
    }
}