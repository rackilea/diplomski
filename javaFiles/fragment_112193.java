@Override
protected void onResume() {  
    super.onResume();
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    String txtColor = prefs.getString("txtColor", DEFAULT COLOR); // for instanse : #ff000099 
    textView.setBackgroundColor(Color.parseColor(txtColor));
}