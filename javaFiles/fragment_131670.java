private String[] Time_CATEGORY = { "Once", "Every 5 Minutes", "Every hour",
            "Every day", "Weekly", "Weekdays(Mon-Fri)", "Weekend",
            "Every month", "Every year" };

    EditText edittextSmsNumber, edittextSmsText;
    String smsNumber, smsText;
    Dialog picker;
    Button select;
    Button set;
    String mytime;
    ImageButton get;
    TimePicker timep;
    DatePicker datep;
    Integer hour, minute, month, day, year, week;
    TextView time, date;
    private PendingIntent pendingIntent;
    static int ResultCode = 12;
    ArrayList<String> sendlist = new ArrayList<String>();
    Spinner spinnerTime;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        edittextSmsNumber = (EditText) findViewById(R.id.smsnumber);
        edittextSmsText = (EditText) findViewById(R.id.smstext);
        ImageButton get = (ImageButton) findViewById(R.id.getc);

        datep = (DatePicker) findViewById(R.id.datePicker);
        timep = (TimePicker) findViewById(R.id.timePicker1);
        Button buttonStart = (Button) findViewById(R.id.startalarm);
        Button buttonCancel = (Button) findViewById(R.id.cancelalarm);
        spinnerTime = (Spinner) findViewById(R.id.spinnerstate);

        ArrayAdapter<String> adapter_state = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Time_CATEGORY);
        adapter_state
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTime.setAdapter(adapter_state);

        spinnerTime.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                    int position, long id) {

                spinnerTime.setSelection(position);
                // spinnerCapital.setSelection(position);

                mytime = (String) spinnerTime.getSelectedItem();

            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        get.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(AndroidAlarmSMS.this,
                        ContactActivity.class);
                startActivityForResult(i, ResultCode);
            }

        });

        buttonStart.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                smsNumber = edittextSmsNumber.getText().toString();
                smsText = edittextSmsText.getText().toString();

                // picker = new Dialog(AndroidAlarmSMS.this);
                // picker.setContentView(R.layout.picker_frag);
                // picker.setTitle("Select Date and Time");

                // set = (Button)picker.findViewById(R.id.btnSet);

                // set.setOnClickListener(new View.OnClickListener() {

                // @Override
                // public void onClick(View view) {

                if (TextUtils.isEmpty(smsNumber)) {

                    finish();
                }

                else {
                    String[] s = edittextSmsNumber.getText().toString()
                            .split(";");

                    for (int i = 0; i < s.length; i++) {
                        // picker.dismiss();

                        Intent myIntent = new Intent(AndroidAlarmSMS.this,
                                MyAlarmService.class);

                        Bundle bundle = new Bundle();
                        bundle.putCharSequence("extraSmsNumber", smsNumber);
                        bundle.putCharSequence("extraSmsText", smsText);
                        myIntent.putExtras(bundle);

                        pendingIntent = PendingIntent.getService(
                                AndroidAlarmSMS.this, 0, myIntent, 0);

                        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                        // long startTime = calendar.getTimeInMillis();

                        // Calendar calendar = Calendar.getInstance();
                        // calendar.setTimeInMillis(System.currentTimeMillis());
                        // calendar.add(Calendar.SECOND, 60);
                        if (mytime.equals("Once")) {
                            Calendar calendar = Calendar.getInstance();

                            calendar.set(datep.getYear(), datep.getMonth(),
                                    datep.getDayOfMonth(),
                                    timep.getCurrentHour(),
                                    timep.getCurrentMinute(), 0);

                            alarmManager.set(AlarmManager.RTC_WAKEUP,
                                    calendar.getTimeInMillis(), pendingIntent);
                        } else if (mytime.equals("Every 5 Minutes")) {
                            Calendar calendar = Calendar.getInstance();

                            calendar.set(datep.getYear(), datep.getMonth(),
                                    datep.getDayOfMonth(),
                                    timep.getCurrentHour(),
                                    timep.getCurrentMinute(), 0);
                            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                                    calendar.getTimeInMillis(), 1000 * 60 * 5,
                                    pendingIntent); // Millisec * Second *
                                                    // Minute
                        } else if (mytime.equals("Every hour")) {
                            Calendar calendar = Calendar.getInstance();

                            calendar.set(datep.getYear(), datep.getMonth(),
                                    datep.getDayOfMonth(),
                                    timep.getCurrentHour(),
                                    timep.getCurrentMinute(), 0);
                            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                                    calendar.getTimeInMillis(), 1000 * 60 * 60,
                                    pendingIntent); // Millisec * Second *
                                                    // Minute
                        } else if (mytime.equals("Every day")) {
                            Calendar calendar = Calendar.getInstance();

                            calendar.set(datep.getYear(), datep.getMonth(),
                                    datep.getDayOfMonth(),
                                    timep.getCurrentHour(),
                                    timep.getCurrentMinute(), 0);
                            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                                    calendar.getTimeInMillis(),
                                    24 * 60 * 60 * 1000, pendingIntent);

                        } else if (mytime.equals("Weekly")) {
                            Calendar calendar = Calendar.getInstance();

                            calendar.set(datep.getYear(), datep.getMonth(),
                                    datep.getDayOfMonth(),
                                    timep.getCurrentHour(),
                                    timep.getCurrentMinute(), 0);
                            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                                    calendar.getTimeInMillis(), 7 * 24 * 60
                                            * 60 * 1000, pendingIntent);

                        } else if (mytime.equals("Weekdays(Mon-Fri)")) {

                            forWeekdays();

                        } else if (mytime.equals("Weekend")) {
                            forWeekend();

                        } else if (mytime.equals("Every month")) {
                            Calendar calendar = Calendar.getInstance();

                            calendar.set(datep.getYear(), datep.getMonth(),
                                    datep.getDayOfMonth(),
                                    timep.getCurrentHour(),
                                    timep.getCurrentMinute(), 0);
                            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                                    calendar.getTimeInMillis(), 30 * 24 * 60
                                            * 60 * 1000, pendingIntent);

                        } else {
                            Calendar calendar = Calendar.getInstance();

                            calendar.set(datep.getYear(), datep.getMonth(),
                                    datep.getDayOfMonth(),
                                    timep.getCurrentHour(),
                                    timep.getCurrentMinute(), 0);
                            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                                    calendar.getTimeInMillis(), 365 * 24 * 60
                                            * 60 * 1000, pendingIntent);

                        }

                        Toast.makeText(
                                AndroidAlarmSMS.this,
                                "Start Alarm with \n" + "smsNumber = "
                                        + smsNumber + "\n" + "smsText = "
                                        + smsText, Toast.LENGTH_LONG).show();
                    }
                }

            }

        });

        // picker.show();

        // }});

        buttonCancel.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.cancel(pendingIntent);
                Toast.makeText(AndroidAlarmSMS.this, "Cancel!",
                        Toast.LENGTH_LONG).show();

            }
        });
    }

    public void forWeekdays() {
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(datep.getYear(), datep.getMonth(), datep.getDayOfMonth(),
                timep.getCurrentHour(), timep.getCurrentMinute(), 0);       
        int day = calendar2.get(Calendar.DAY_OF_WEEK);      
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        if (day == 2 || day == 3 || day == 4 || day == 5 || day == 6) {
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                    calendar2.getTimeInMillis(), 24 * 60 * 60 * 1000,
                    pendingIntent);
        }

    }

    public void forWeekend() {
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(datep.getYear(), datep.getMonth(), datep.getDayOfMonth(),
                timep.getCurrentHour(), timep.getCurrentMinute(), 0);       
        int day = calendar2.get(Calendar.DAY_OF_WEEK);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        if (day == 1 || day == 7) {
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                    calendar2.getTimeInMillis(), 24 * 60 * 60 * 1000,
                    pendingIntent);
        }

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == ResultCode) {

            if (resultCode == RESULT_OK) {
                sendlist = data.getStringArrayListExtra("name");
                if (sendlist != null) {
                    for (int i = 0; i < sendlist.size(); i++) {
                        edittextSmsNumber.append(sendlist.get(i).toString());
                        edittextSmsNumber.append(";");
                    }

                }
                if (resultCode == RESULT_CANCELED) {

                }
            }
        }