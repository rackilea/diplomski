//start service from activity or any place
Intent intent = new Intent(this, MyService.class);
            Bundle bundle = new Bundle();
            bundle.putString("TEST", "test got it.");
            intent.putExtras(bundle);
            startService(intent);


//In service class declare override method of service
@Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        if (intent != null && intent.getExtras() != null) {
            String str = intent.getExtras().getString("TEST");
            Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG)
                    .show();
        }
        return START_NOT_STICKY;
    }