PendingIntent serviceIntent= PendingIntent.getService(context,
                    0, new Intent(context, MyService.class), 0);

            long firstTime = SystemClock.elapsedRealtime();
            AlarmManager am = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);

            long currenciesIntervalInSec = 3600;

            if (automaticCurrencies)
                am.setRepeating(AlarmManager.ELAPSED_REALTIME, firstTime, currenciesIntervalInSec*1000, serviceIntent);