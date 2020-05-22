MultiSelectListPreference listPreference = new MultiSelectListPreference(context);
    listPreference.setTitle(R.string.configure_category_title);
    listPreference.setDialogTitle(R.string.configure_category_title);
    listPreference.setSummary(R.string.configure_category_summary);
    listPreference.setEntries(R.array.configure_category_array);
    listPreference.setEntryValues(new CharSequence[]{
            ProcessList.PREF_SERVICES + mAppWidgetId,
            ProcessList.PREF_INACTIVE + mAppWidgetId,
            ProcessList.PREF_INTERNAL + mAppWidgetId
    });

    //Create a Set<String> with list items that should be selected
    SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
    boolean showServices = sharedPref.getBoolean(ProcessList.PREF_SERVICES + mAppWidgetId, true);
    boolean showInactive = sharedPref.getBoolean(ProcessList.PREF_INACTIVE + mAppWidgetId, true);
    boolean showInternal = sharedPref.getBoolean(ProcessList.PREF_INTERNAL + mAppWidgetId, true);

    String[] strings = new String[3];
    int cnt = 0;
    if (showServices)
        strings[cnt++] = ProcessList.PREF_SERVICES + mAppWidgetId;
    if (showInactive)
        strings[cnt++] = ProcessList.PREF_INACTIVE + mAppWidgetId;
    if (showInternal)
        strings[cnt] = ProcessList.PREF_INTERNAL + mAppWidgetId;

    Set<String> mySet = new HashSet<String>();
    Collections.addAll(mySet, strings);

    //Add the set
    listPreference.setValues(mySet);

    //Listen for changes, I'm not sure if this is how it's meant to work, but it does :/
    listPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
        public boolean onPreferenceChange(Preference preference, Object o) {

            HashSet hashSet = (HashSet) o;
            Iterator stringIterator = hashSet.iterator();
            boolean[] states = {false, false, false};
            String prefString;

            while (stringIterator.hasNext()) {

                prefString = (String) stringIterator.next();

                if (prefString == null)
                    continue;

                if (prefString.compareTo(ProcessList.PREF_SERVICES + mAppWidgetId) == 0)
                    states[0] = true;
                else if (prefString.compareTo(ProcessList.PREF_INACTIVE + mAppWidgetId) == 0)
                    states[1] = true;
                else if (prefString.compareTo(ProcessList.PREF_INTERNAL + mAppWidgetId) == 0)
                    states[2] = true;

            }

            PreferenceManager
                    .getDefaultSharedPreferences(getActivity())
                    .edit()
                    .putBoolean(ProcessList.PREF_SERVICES + mAppWidgetId, states[0])
                    .putBoolean(ProcessList.PREF_INACTIVE + mAppWidgetId, states[1])
                    .putBoolean(ProcessList.PREF_INTERNAL + mAppWidgetId, states[2])
                    .commit();

            return true;
        }
    });

    preferenceCategory.addPreference(listPreference);