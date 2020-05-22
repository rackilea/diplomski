BroadcastReceiver br = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        this.finish();
        Log.i(TAG," get activity-reference --> this ");
        }
    };

    context.getApplicationContext().registerReceiver(br, new IntentFilter("com.cocus.panicbutton.anotherbroadcast") );          
    PendingIntent pi = PendingIntent.getBroadcast( context.getApplicationContext(), 0, new Intent("com.cocus.panicbutton.anotherbroadcast"),0 );
    AlarmManager am = (AlarmManager)(context.getApplicationContext().getSystemService( Context.ALARM_SERVICE ));

    Log.i(TAG,"receiver registered");
// starting the Alarm-Timer    
    am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() +2*1000, pi);
// 2*1000 = 2 seconds