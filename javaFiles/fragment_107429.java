private String formatHighLows(double high, double low){

     SharedPreferences sharedPrefs =
             PreferenceManager.getDefaultSharedPreferences(getActivity());
     String unitType = sharedPrefs.getString(
             getResources().getString(R.string.pref_units_key),
             getResources().getString(R.string.pref_units_metric));

     if(unitType.equals(getResources().getString(R.string.pref_units_imperial))){
         high = (high * 1.8) + 32;
         low = (low * 1.8) + 32;
     }else if(!unitType.equals(getResources().getString(R.string.pref_units_metric))){
         Log.d(LOG_TAG, "Unit type not found: " + unitType); }
 }