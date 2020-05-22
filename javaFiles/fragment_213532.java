@Override
public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
    if(which == 0) {
      Time1.setText(  hourOfDay + ":" +minute); 
    }
    else if (which == 1) {
      Time2.setText(  hourOfDay + ":" +minute); 
    }
}