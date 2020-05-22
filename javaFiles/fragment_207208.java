//declare as global
SharedPreferences prefs = null;

//and in your onCreate method:
prefs = getSharedPreferences("packageNameHere", MODE_PRIVATE);

if (prefs.getBoolean("firstrun", true)) { 
    //do stuff here if first run

    //make sure to flag the boolean as false
    prefs.edit().putBoolean("firstrun", false).commit();
}
else{
    //if not first run, do something else
}