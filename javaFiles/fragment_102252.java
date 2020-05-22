public class Main extends Activity {

    private int currentYear;
    private int currentMonth;
    private int currentDay;
    static final int DATE_DIALOG_ID = 0;
    static final int TIME_DIALOG_ID = 1;
    int hour;
    int minute;
    String cabin1 = "The Wooden Castle";
    String cabin2 = "Cozy Little Spot";
    private Button btDate;
    private Button btTime;
    private TextView timeDisplay;
    private TextView dateDisplay;
    private RadioButton c1;
    private RadioButton c2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Calendar c = Calendar.getInstance();
        currentYear = c.get(Calendar.YEAR);
        currentMonth = c.get(Calendar.MONTH);
        currentDay = c.get(Calendar.DAY_OF_MONTH);
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        timeDisplay = (TextView) findViewById(R.id.txtTime);
        dateDisplay = (TextView) findViewById(R.id.txtDate);
        btDate = (Button) findViewById(R.id.btnDate);
        btTime = (Button) findViewById(R.id.btnTime);
        c1 = (RadioButton) findViewById(R.id.radCabin1);
        c2 = (RadioButton) findViewById(R.id.radCabin2);
        btDate.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                showDialog(DATE_DIALOG_ID);
            }
        });
        btTime.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID);
            }
        });
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
        case DATE_DIALOG_ID:
            return new DatePickerDialog(this, reservationDate, currentYear,
                    currentMonth, currentDay);
        case TIME_DIALOG_ID:
            return new TimePickerDialog(this, timeDate, hour, minute, false);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener reservationDate = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int month, int day) {
            if (c1.isChecked()) {

                dateDisplay.setText("Your rental time is set for "
                        + (month + 1) + "-" + day + "-" + year + " to "
                        + (month + 1) + "-" + (day + 3) + "-" + year + " in "
                        + cabin1 + ".");
            }
            if (c2.isChecked()) {
                dateDisplay.setText("Your rental time is set for "
                        + (month + 1) + "-" + day + "-" + year + " to "
                        + (month + 1) + "-" + (day + 3) + "-" + year + " in "
                        + cabin2 + ".");
            }
        }

    };

    private TimePickerDialog.OnTimeSetListener timeDate = new TimePickerDialog.OnTimeSetListener() {

        public void onTimeSet(TimePicker view, int hours, int minutes) {
            timeDisplay.setText("Your arrival time will be at " + hours + ":"
                    + minutes + ".");
        }
    };

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}