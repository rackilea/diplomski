public class MainActivity extends Activity
{
       @Override
       public void onCreate(Bundle savedInstanceState) 
      {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.main);
      }

    public void scheduleAlarm(View V)
    {
            // time at which alarm will be scheduled here alarm is scheduled at 1 day from current time, 
            // we fetch  the current time in milliseconds and added 1 day time
            // i.e. 24*60*60*1000= 86,400,000   milliseconds in a day        
            Long time = new GregorianCalendar().getTimeInMillis()+24*60*60*1000;

            // create an Intent and set the class which will execute when Alarm triggers, here we have
            // given AlarmReciever in the Intent, the onRecieve() method of this class will execute when
            // alarm triggers and 
            //we call the method inside onRecieve() method pf Alarmreciever class
            Intent intentAlarm = new Intent(this, AlarmReciever.class);

            // create the object
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            //set the alarm for particular time
            alarmManager.set(AlarmManager.RTC_WAKEUP,time, PendingIntent.getBroadcast(this,1,  intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT));
            Toast.makeText(this, "Alarm Scheduled for Tommrrow", Toast.LENGTH_LONG).show();

    }
}