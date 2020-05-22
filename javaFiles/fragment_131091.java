protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_display_message);
    // Show the Up button in the action bar. 
    getActionBar().setDisplayHomeAsUpEnabled(true);

timepicker = (TimePicker) findViewById(R.id.timePicker1);
timepicker.setIs24HourView(true);
hour1 = timepicker.getCurrentHour();
min1 = timepicker.getCurrentMinute();