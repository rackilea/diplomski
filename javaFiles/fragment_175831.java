public void readSSOInfo(){
  Context con;
     try {
         con = createPackageContext("com.app.packagename1", 0);
         SharedPreferences pref = con.getSharedPreferences("CheckSSO", Context.MODE_PRIVATE);
         dataShared = pref.getBoolean("isLoggedIn", false);
     }
     catch (Exception e) {
         Log.e("Not data shared", e.toString());
     }
}