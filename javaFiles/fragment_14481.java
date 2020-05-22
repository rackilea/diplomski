...

SharedPreferences preferences;
SharedPreferences.Editor editor;

...

@Override
public void onCreate(Bundle savedInstanceState){

    ...

    preferences = PreferenceManager.getDefaultSharedPreferences(this);
    editor = preferences.edit();

    ...

}