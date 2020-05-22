public static final String MOVEMENT_UPDATE = "com.client.gaitlink.AccelerationService.action.MOVEMENT_UPDATE";
    public static final String ACCELERATION_X = "com.client.gaitlink.AccelerationService.ACCELERATION_X";
    public static final String ACCELERATION_Y = "com.client.gaitlink.AccelerationService.ACCELERATION_Y";
    public static final String ACCELERATION_Z = "com.client.gaitlink.AccelerationService.ACCELERATION_Z";

private void announceAccelerationChanges()//this method sends broadcast messages
    {
        Intent intent = new Intent(MOVEMENT_UPDATE);
        intent.putExtra(ACCELERATION_X, accelerationX);
        intent.putExtra(ACCELERATION_Y, accelerationY);
        intent.putExtra(ACCELERATION_Z, accelerationZ);

        sendBroadcast(intent);
    }