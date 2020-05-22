.......
whatYouSaid = results.get(0);

 Sharedpreferences sp = getSharedPreferences("UR_UNIQ_PREF_ID", Context.MODE_PRIVATE);
  Editor editor = sp.edit();
  editor.putString("WHATYOUSAID", whatyousaid);
 editor.commit();

//Then start your another activity

//Then in your next activity

oncreate(){

......
 Sharedpreferences sp = getSharedPreferences("UR_UNIQ_PREF_ID", Context.MODE_PRIVATE);
 String whatyousaid =  sp.getString("UR_UNIQ_PREF_ID","");

}