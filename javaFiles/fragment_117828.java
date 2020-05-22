SharedPreferences settings = getSharedPreferences("pref_name", 0);
 boolean installed = settings.getBoolean("installed", false);

if(!installed){

   //showDialog

   SharedPreferences.Editor editor = settings.edit();
   editor.putBoolean("installed", true);
   editor.commit();

}