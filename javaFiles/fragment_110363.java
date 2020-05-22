@Override
 protected void onResume()
{
  super.onResume();
  String errorMsg =context.getSharedPreferences ("ThisActivityName", Context.MODE_PRIVATE).getString ("error");
  if (errorMsg.equals ("You have an error")){
    //update fragment code here.  
    //set SharedPreference errorMessage key to hold something else.
  } 
}