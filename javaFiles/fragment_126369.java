lv.setClickable(true);
lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

  @Override
  public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

    Object o = lv.getItemAtPosition(position);
    /* write you handling code like...
    String st = "sdcard/";
    File f = new File(st+o.toString());
    // do whatever u want to do with 'f' File object
    */  
  }
});