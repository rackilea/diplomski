//to know when service is connected or disconnected to this activity
private ServiceConnection serviceconnection=new ServiceConnection() {
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        MyService.MyBinder mybinder=(MyService.MyBinder)service;
        myservice=mybinder.getService();//a reference of MyService
        myservice.startDownloading();//your function for downloading image


    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.i("","disconnected to service");


    }
};