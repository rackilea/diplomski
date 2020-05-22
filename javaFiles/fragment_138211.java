String s = "1_2_5_7_12_";

  SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
  Editor edit = preferences.edit();
  edit.putString("pref_str", s); 
  edit.commit();//storing
  // Retrieve
  String pref_numstr =  preferences.getString("pref_str", "n/a");
  ar = pref_numstr.split("_");
  System.out.println(ar.length);