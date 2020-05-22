public class MyReceiver extends BroadcastReceiver {

PowerManager powerManager;
PowerManager.WakeLock wakeLock;
AlarmManager alarmManager;
Calendar c;
SimpleDateFormat formatter;
String dateFormat;


@Override
public void onReceive(final Context context, Intent intent) {
    //acquire wake lock
    powerManager = (PowerManager) context.getSystemService(POWER_SERVICE);
    wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "MyWakelockTag");
    wakeLock.acquire();

    alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    c = Calendar.getInstance();
    c.set(Calendar.HOUR_OF_DAY, 12);
    c.set(Calendar.MINUTE, 00);
    Long daily = 24L * 60L * 60L * 1000L;
    //Set Unlocked notification broadcast
    Intent intentnew= new Intent(context, MyService.class);
    PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intentnew, PendingIntent.FLAG_UPDATE_CURRENT);

    dateFormat = "dd/MM/yyyy HH:mm";
    formatter = new SimpleDateFormat(dateFormat);
    Toast.makeText(context, "Alarm is set for " + formatter.format(c.getTimeInMillis()+daily), Toast.LENGTH_SHORT).show();
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, (c.getTimeInMillis() + daily), pendingIntent);
    } else {
        alarmManager.set(AlarmManager.RTC_WAKEUP, (c.getTimeInMillis() + daily), pendingIntent);
    }

    final Handler mHandler = new Handler();

    Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            //DO your Work for each Hour
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            String finalPhonenumber = Globals.sms1PhoneNumbers.get(rad).number + context.getResources().getString(R.string.extention);
            callIntent.setData(Uri.parse("tel:" + finalPhonenumber));
            context.startActivity(callIntent);
            Toast.makeText(context, "It Ran", Toast.LENGTH_SHORT).show();
            //Also post your mHandler for next hour

            if (System.currentTimeMillis() < c.getTimeInMillis()) {
                mHandler.postDelayed(this, 60L * 60L * 1000L);
                Toast.makeText(context, "Task will repeat after an hour", Toast.LENGTH_SHORT).show();
            }

        }
    };

    c = Calendar.getInstance();
    c.set(Calendar.HOUR_OF_DAY, 18);
    c.set(Calendar.MINUTE, 00);
    mHandler.post(mRunnable);

    wakeLock.release();
}