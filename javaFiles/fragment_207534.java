@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //preferences = getSharedPreferences(SETTINGS, MODE_PRIVATE);
        //use this instead:
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean firstUse = preferences.getBoolean(FIRST_USE, true);
        if (firstUse){
            Toast helloMessage = Toast.makeText(getApplicationContext(), "Hello First Time User",Toast.LENGTH_LONG);
            helloMessage.show();
            editor = preferences.edit();
            editor.putBoolean(FIRST_USE, false);
            editor.putBoolean  ("focus", false);
/*NOTE THE MATCHED STRING  vvvvv
      <CheckBoxPreference
              android:key="focus"   android:title="@string/focusAfterShow" android:summary="Always place the cursor" android:defaultValue="false"/> */
            editor.putBoolean  ("screen", false);
/*NOTE THE MATCHED STRING  vvvvvv
      <CheckBoxPreference
              android:key="screen"  android:title="@string/screenSaver" android:summary="Keep screen on" android:defaultValue="false" /> */
            editor.commit();
        }
        else {
            ///////////////////// problems here *******************
            //no need to create another preferences, it's already defined above
            //SharedPreferences preferences = getSharedPreferences(SETTINGS, MODE_PRIVATE);

            //This should work now!!!!!!
            focusAtClue = preferences.getBoolean("focus",focusAtClue);
            screenSaver = preferences.getBoolean("screen",screenSaver);
            Log.w("oncreate:", focusAtClue + " " + screenSaver);
            Toast helloMessage = Toast.makeText(getApplicationContext(), "Hello Returning User " + focusAtClue + " " + screenSaver,Toast.LENGTH_LONG);
            helloMessage.show();
            ///////////////////// problems
        }
    }