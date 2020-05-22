public class AlarmHelper  {

Activity activity;

public AlarmHelper(Activity activity){
  this.activity=activity;
}

    public void setupDatePicker(){
        long maxTime = 52560000;
        final Calendar cal = Calendar.getInstance();
        DatePicker dp = (DatePicker)activity.findViewById(R.id.datePicker);
        dp.setMinDate(cal.getTimeInMillis() - 1000);
        dp.setMaxDate(cal.getTimeInMillis() + maxTime);
    }

}