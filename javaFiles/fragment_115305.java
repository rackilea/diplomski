AlarmManager mgr=(AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
            Intent i=new Intent(this, AlarmReceiver.class);
            PendingIntent pi=PendingIntent.getBroadcast(this, 1, i, PendingIntent.FLAG_UPDATE_CURRENT);
            mgr.cancel(pi);
            long MINUTE=AlarmManager.INTERVAL_HOUR/60;
            long TIMER=MINUTE*minutes;
            mgr.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime(), TIMER , pi);