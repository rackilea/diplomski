//In your DatePickerFragment
MyInterface i;

@Override
public void onAttach (Activity theParentActivity) {
  i = (MyInterface) theParentActivity;
}

@Override
public void onDateSet(DatePicker view, int year, int month, int day)
{
  //Here you call the interface
  i.changeTheButton(/* you send the neccesary info from your date to your activity */);
  dateToString(year, month, day);
}