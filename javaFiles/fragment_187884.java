class SettingsActivity : FragmentActivity(), PreferenceFragmentCompat.OnPreferenceDisplayDialogCallback {
        private val DIALOG_FRAGMENT_TAG = "android.support.v7.preference.PreferenceFragment.DIALOG"

        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)

                supportFragmentManager.beginTransaction()
                                .replace(android.R.id.content, SettingsFragment(), "setting_fragment").commit()
        }

        override fun onPreferenceDisplayDialog(caller: PreferenceFragmentCompat, preference: Preference?): Boolean {
                // check if dialog is already showing
                if (supportFragmentManager!!.findFragmentByTag(DIALOG_FRAGMENT_TAG) != null) {
                        return true
                }

                val f: DialogFragment
                if (preference is EditTextPreference) {
                        f = EditTextPreferenceDialogFragmentCompat.newInstance(preference.getKey())
                } else if (preference is ListPreference) {
                        f = ListPreferenceDialogFragmentCompat.newInstance(preference.getKey())
                } else if (preference is AbstractMultiSelectListPreference) {
                        f = MultiSelectListPreferenceDialogFragmentCompat.newInstance(preference.getKey())
                } else {
                        throw IllegalArgumentException("Tried to display dialog for unknown " + "preference type. Did you forget to override onDisplayPreferenceDialog()?")
                }

                f.setTargetFragment(supportFragmentManager.findFragmentByTag("setting_fragment"), 0)

                f.isCancelable = false // !! HERE !!

                f.show(supportFragmentManager!!, DIALOG_FRAGMENT_TAG)

                return true
        }
}