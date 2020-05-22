SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
String whichButton = appSharedPrefs.getString("buttonPressed", "");
if(whichButton.equals("Button1")
 //do something
if(whichButton.equals("Button2")
 //do something
if(whichButton.equals("Button3")
 //do something