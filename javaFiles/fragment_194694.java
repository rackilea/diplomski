private int TIME_PICKER_DIALOG_TAG;
@Override
public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
    String hourString = hourOfDay < 10 ? "0"+hourOfDay : ""+hourOfDay;
    String minuteString = minute < 10 ? "0"+minute : ""+minute;
    String secondString = second < 10 ? "0"+second : ""+second;

    SimpleDateFormat  df = new SimpleDateFormat("hh:mm a");
    mCalendar = Calendar.getInstance();
    mCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
    mCalendar.set(Calendar.MINUTE, minute);
    mCalendar.set(Calendar.SECOND,0);

    Date date = mCalendar.getTime();
    if(TIME_PICKER_DIALOG_TAG == 2) {
        alertTime.setText(df.format(date));
    }else if(TIME_PICKER_DIALOG_TAG  == 4){
        dueTime.setText(df.format(date));
    }
}


alertTime.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        TIME_PICKER_DIALOG_TAG = 2;

        Calendar now = Calendar.getInstance();

        TimePickerDialog tpd = TimePickerDialog.newInstance(
            AddTaskActivity.this,
            now.get(Calendar.HOUR_OF_DAY),
            now.get(Calendar.MINUTE),
            mHoursMode
        );

        tpd.setOnCancelListener(new DialogInterface.OnCancelListener() {
        @Override
        public void onCancel(DialogInterface dialogInterface) {
            Log.d("TimePicker", "Dialog was cancelled");
        }
        });
        tpd.show(getFragmentManager(), "Timepickerdialog");
    }
});


dueTime.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        TIME_PICKER_DIALOG_TAG = 4;

        Calendar now = Calendar.getInstance();

        TimePickerDialog tpd = TimePickerDialog.newInstance(
            AddTaskActivity.this,
            now.get(Calendar.HOUR_OF_DAY),
            now.get(Calendar.MINUTE),
            mHoursMode
        );

        tpd.setOnCancelListener(new DialogInterface.OnCancelListener() {
        @Override
        public void onCancel(DialogInterface dialogInterface) {
            Log.d("TimePicker", "Dialog was cancelled");
        }
        });
        tpd.show(getFragmentManager(), "Timepickerdialog");
    }
});