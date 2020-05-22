@Override
protected void onResume()
{
     super.onResume();
     TimePicker picker = (TimePicker) findViewById(R.id.startTimePicker);

     picker.setCurrentMinute(10);
     picker.setCurrentHour(12);
}