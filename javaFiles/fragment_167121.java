switch(view.getId()) {
case R.id.checkBox1:
    PreferenceManager.getDefaultSharedPreferences(this).edit()
        .putBoolean("checkBox1", checked).commit();
    break;
}