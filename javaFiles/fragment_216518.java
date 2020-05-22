TextView moon_ra; 

@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {
    final Calendar calendar = Calendar.getInstance();
    int yy = calendar.get(Calendar.YEAR);
    int mm = calendar.get(Calendar.MONTH);
    int dd = calendar.get(Calendar.DAY_OF_MONTH);

    moon_ra = (TextView)getActivity().findViewById(R.id.moon_ra);

    return new DatePickerDialog(getActivity(), this, yy, mm, dd);
}