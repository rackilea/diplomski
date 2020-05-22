public void onCreate() {
  super.onCreate() 
  ...


  if (!sharedPref.get("USER_SAW_THE_OTHER_ACTIVITY")) { 
        startActivity(new Intent(...));
  }
}