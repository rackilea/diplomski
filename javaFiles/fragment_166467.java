public void buttonClick(View v) {
  switch(v.getId()) {
    case R.id.btnContactDev:
      Intent myIntent = new Intent();
      myIntent.setClassName(your_package_name_string, your_activity_name_string);
      // for ex: your package name can be "com.example"
      // your activity name will be "com.example.Contact_Developer"
      startActivity(myIntent);
    break;
  }
}