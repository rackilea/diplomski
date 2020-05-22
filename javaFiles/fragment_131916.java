@Override
protected void onCreate(Bundle savedInstanceState) {
    if(savedInstanceState == null) {
        // The Activity is brand new
        AgeCalculation();
    }
    else {
        // The Activity has been re-created
        AfterFirstLaunch();
    }

    // ... Other stuff
}