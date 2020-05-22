@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    CheckBox oneRunCheckbox = (CheckBox) findViewById(R.id.addOneForTeamA);
    boolean isOneRun = oneRunCheckbox.isChecked();
}