long _alarm;

        Calendar now = Calendar.getInstance();
        Calendar wakeupcall = Calendar.getInstance();
        wakeupcall.setTimeInMillis(System.currentTimeMillis());
        wakeupcall.set(Calendar.HOUR_OF_DAY, 18);
        wakeupcall.set(Calendar.MINUTE, 30);

        if (wakeupcall.getTimeInMillis() <= now.getTimeInMillis())
            _alarm=wakeupcall.getTimeInMillis() + (AlarmManager.INTERVAL_DAY+1);
        else
            _alarm=wakeupcall.getTimeInMillis();

al = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        notif= new Intent(this,TestNotifyService.class);
        fintent = PendingIntent.getService(this,0,notif,0);

if (SDK_INT < Build.VERSION_CODES.KITKAT) {
            al.set(AlarmManager.RTC_WAKEUP,_alarm, fintent);
        }
        else if (Build.VERSION_CODES.KITKAT <= SDK_INT  && SDK_INT < Build.VERSION_CODES.M) {
            al.setExact(AlarmManager.RTC_WAKEUP,_alarm,fintent);
        }
        else if (SDK_INT >= Build.VERSION_CODES.M) {
            al.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,_alarm,fintent);
        }