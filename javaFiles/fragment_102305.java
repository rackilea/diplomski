public static final String MyPREFERENCES = "MyPrefs" ;
SharedPreferences sharedpreferences;
private void setAlarm(Calendar targetCal){
    sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedpreferences.edit();
    editor.putString("name",name);
    editor.putString("ID",ID);
    editor.commit();

    Toast.makeText(getApplicationContext(),
            "Alarm is set for " + targetCal.getTime(),Toast.LENGTH_LONG).show();

    Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
    PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(),Alarmnum,intent, 0);
    AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
    alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);

}