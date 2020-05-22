SharedPreferences wmbPreference1,wmbPreference2;    
SharedPreferences.Editor editor;

//wmbPreference for Shared Prefs that lasts forever
wmbPreference1 = PreferenceManager.getDefaultSharedPreferences(this);  

//installsp for Shared Prefs that lasts only just once each time program is running
wmbPreference2 =getApplicationContext().getSharedPreferences("MYKEY",Activity.MODE_PRIVATE);