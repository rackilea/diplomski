@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {
    final Calendar c = Calendar.getInstance();
    int hour = c.get(Calendar.HOUR_OF_DAY);
    // Convert current minutes to tens
    // 55 = 50, 56 = 00
    int minute = c.get(Calendar.MINUTE) / 10;
    minute = (minute > 5) ? 0 : minute;

    // Create a new instance of TimePickerDialog and return it
    final TimePickerDialog tpd = new TimePickerDialog(getActivity(), this, hour, minute,
            DateFormat.is24HourFormat(getActivity()));

    tpd.setOnShowListener(new DialogInterface.OnShowListener() {
        @Override
        public void onShow(DialogInterface dialog) {
            int tpLayoutId = getResources().getIdentifier("timePickerLayout", "id", "android");

            ViewGroup tpLayout = (ViewGroup) tpd.findViewById(tpLayoutId);
            ViewGroup layout = (ViewGroup) tpLayout.getChildAt(0);

            // Customize minute NumberPicker
            NumberPicker minutePicker = (NumberPicker) layout.getChildAt(2);
            minutePicker.setDisplayedValues(new String[]{"00", "10", "20", "30", "40", "50"});
            minutePicker.setMinValue(0);
            minutePicker.setMaxValue(5);
        }
    });

    return tpd;
}

public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
    minute = minute * 10;
    Toast.makeText(getActivity(), "Selected minute: " + minute, Toast.LENGTH_LONG).show();
}