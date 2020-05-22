@Override
public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
    Calendar mDate = Calendar.getInstance();
    mDate.set(year, monthOfYear, dayOfMonth);
    SimpleDateFormat mDateFormat = new SimpleDateFormat("EEEE, MMMMM dd, yyyy");
    myDate.setText(mDateFormat.format(mDate.getTime()));
}