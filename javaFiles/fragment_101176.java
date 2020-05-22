private boolean isPreferenzeRunning = false;
...
listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
      public void onSharedPreferenceChanged(SharedPreferences prefs, String listpref) {       
            if(!isPreferenzeRunning)preferenze();
          }
   };
...
private void preferenze()
    isPreferenzeRunning = true;
    try{
       ...
    }finally{isPreferenzeRunning = false;}       
}