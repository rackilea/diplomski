Intent intent=new Intent(context,YourActivity.class);
intent.putExtra("your first value",title);
intent.putExtra("your second value", desc);

PendingIntent sender = PendingIntent.getBroadcast(context,(int)requestcode, intent, PendingIntent.FLAG_UPDATE_CURRENT);

AlarmManager am = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);

am.set(AlarmManager.RTC_WAKEUP,alarm_time,sender);