@Override
protected void onResume() {
    super.onResume();

    button.setText(this.getButtonText()); 
}


public String getButtonText()
{
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    String buttonText = prefs.getString("ButtonText", "Default button text");
    return buttonText;
}