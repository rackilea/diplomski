public void onClick(View v) {
    EditText editText = (EditText) v;
    if (tp==null || !tp.isAdded()){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        tp = new TimePick(editText);
        tp.show(ft, "TimePicker");
    }
}

@Override
public void onStop() {
    super.onStop();
    if (tp.isAdded()) tp.dismiss();
}

public static class TimePick extends android.app.DialogFragment implements TimePickerDialog.OnTimeSetListener {

    private EditText editText;

    public TimePick(EditText editText) {
        this.editText = editText;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(TimePicker view, int hourofDay, int minute) {
        editText.setText(Integer.toString(hourofDay) + ":" + Integer.toString(minute));
    }
}