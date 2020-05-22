protected void onSaveInstanceState(Bundle icicle) {
  super.onSaveInstanceState(icicle);
  icicle.putLong("starttime", startTime);
}

public void onCreate(Bundle savedInstanceState) {
  if (savedInstanceState != null){
     startTime = savedInstanceState.getLong("starttime");
  }else{
     startTime = System.currentTimeMillis();
  }
}