public class Outside
{
private String timeStamp;

 TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet( TimePicker view, int hourOfDay, int minute ) {
              c.set( Calendar.HOUR_OF_DAY, hourOfDay );
              c.set( Calendar.MINUTE, minute );
              String hour = Integer.toString(hourOfDay);
              String min = Integer.toString(minute);
              timeStamp = hour + ":" + min;

            }
          };
}