@Override
protected void onCreate(Bundle savedInstanceState) {
    SharedPreferences shoulderPreference = getApplicationContext().getSharedPreferences("ShoulderWeightPreference", Context.MODE_PRIVATE);

    // The second parameter in getString() is the default value which
    // is returned if the prefernece "storednewweight" does not
    // exist (yet)
    String prefValue =  shoulderPreference.getString("storednewweight", "");

    if(prefValue.equals("")) {
        // The preference was not created before
        AgeCalculation();
    }
    else {
        // Preference already created
        AfterFirstLaunch();
    }

    // ... Other stuff
}