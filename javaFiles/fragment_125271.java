@Override
public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    setContentView(R.layout.calculator);

    final SharedPreferences prefs = PreferenceManager
            .getDefaultSharedPreferences(this);

    String result= prefs.getString("result",""); //where "" is your default value
    if(!result.equals("") && !result.isEmpty()){
      textViewResult.setText(addNumbers());
    }


/*other code*/