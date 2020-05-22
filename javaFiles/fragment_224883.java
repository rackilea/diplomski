@Override
protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_accounts);
     myPrefs = PreferenceManager.getDefaultSharedPreferences(this);
     ...
}