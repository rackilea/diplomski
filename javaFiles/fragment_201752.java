@Override
    public void onResume()
    {   

        IntentFilter movementFilter;
        movementFilter = new IntentFilter(AccelerationService.MOVEMENT_UPDATE);
        accelerationReceiver = new AccelerationServiceReceiver();
        registerReceiver(accelerationReceiver, movementFilter);


        startAccelerationService();

        super.onResume();
    }

    private void startAccelerationService()
    {
        startService(new Intent(this, AccelerationService.class));
    }

    public class AccelerationServiceReceiver extends BroadcastReceiver
    {
      @Override
        public void onReceive(Context context, Intent intent)//this method receives broadcast messages. Be sure to modify AndroidManifest.xml file in order to enable message receiving
        {
            accelerationX = intent.getDoubleExtra(AccelerationService.ACCELERATION_X, 0);
            accelerationY = intent.getDoubleExtra(AccelerationService.ACCELERATION_Y, 0);
            accelerationZ = intent.getDoubleExtra(AccelerationService.ACCELERATION_Z, 0);

            announceSession();

            updateGUI();
        }
    }