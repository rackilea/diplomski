@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_activity); 
     // getpreferences
     SharedPreferences settings = getSharedPreferences("Your preference file", 0);  
     final float  value= settings.getFloat("flick_level_number", your default value);
     final int value1 = settings.getInt("flick_level_number", your default value);
         final String value2 = settings.getIString("flick_level_number", "your default value");

}