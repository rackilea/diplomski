SharedPreferences prefs =PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
boolean idHasBeenGenerated = prefs.getBoolean("idgenerated", false);

if(!idHasBeenGenerated){
    String uuid = UUID.randomUUID().toString();

//do your thing with PreferenceConnector
    Editor editor=prefs.edit();
    editor.putBoolean("idgenerated", true);
    editor.commit();
}else{          
    //Do nothing ID has already been generated
}