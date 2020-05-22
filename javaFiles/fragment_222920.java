public void onReceive(Context context, Intent intent) {
      updateUI(intent);
}

private void updateUI(Intent intent) {
  Bundle extra = intent.getBundleExtra("extra"); //use intent NOT getIntent()
  ArrayList<Object> databaseList = (ArrayList<Object>)
  extra.getSerializable("objects");
  fillMasterTable(databaseList);
}