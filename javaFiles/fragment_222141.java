protected void onStart(){
    super.onStart();
    SharedPreferences settings = getApplicationContext().getSharedPreferences(GEMFFS, 0);
    KTO = settings.getString("KT", null);
    KT = Double.valueOf(KTO);

}