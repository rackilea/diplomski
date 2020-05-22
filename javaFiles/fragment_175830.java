public void writeSSOInfo(){
            SharedPreferences prefs = getSharedPreferences("CheckSSO",Context.MODE_WORLD_READABLE);
            SharedPreferences.Editor editor = prefs.edit();
         if(userLoggedIn){
            editor.putBoolean("isLoggedIn", true);
            }else{
           editor.putBoolean("isLoggedIn", false);
              }
            editor.commit();
        }