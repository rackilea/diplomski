public static class DatePickerFragment extends DialogFragment implements OnDateSetListener{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {...}


   @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,monthOfYear);
        calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        userDate = userFormat.format(calendar.getTime());
        sysDate = sysFormat.format(calendar.getTime());
        TextView displayDate = (TextView)getActivity().findViewById(R.id.displayDate);
        displayDate.setText(userDate);
        ((MainActivity)getActivity()).reloadMap();
    }