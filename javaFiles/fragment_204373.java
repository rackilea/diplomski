//Global variable, you can initialize inside OnCreate Method 
Calendar now = Calendar.getInstance();

public void show() {

DatePickerDialog dpd = DatePickerDialog.newInstance(
      PostInfoUpdate.this,
      now.get(Calendar.YEAR),
      now.get(Calendar.MONTH),
      now.get(Calendar.DAY_OF_MONTH)
);

dpd.setMinDate(Calendar.getInstance());
now.add(Calendar.DAY_OF_MONTH, 30);
dpd.setMaxDate(now);
dpd.show(getFragmentManager(), "Datepickerdialog");
}


@Override
public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
 String date = "You picked the following date: "+dayOfMonth+"/"+(++monthOfYear)+"/"+year;
 dateTextView.setText(date);
 now.set(Calendar.YEAR, year);
 now.set(Calendar.MONTH, monthOfYear);
 now.set(Calendar.DAY_OF_MONTH, dayOfMonth);
}