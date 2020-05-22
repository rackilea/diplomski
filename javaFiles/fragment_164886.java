public class MessageService extends Service implements LocationListener {
    int counter = 0;
    private Timer timer = new Timer();
    public String textTime, phoneNumber;
    public int updateInterval;
    int lat, lng;
    String coordinates, latitude, longitude;
    LocationManager locationManager;

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        //receives the intent extras from the calling intent
        textTime = intent.getStringExtra("textTime");
        phoneNumber = intent.getStringExtra("phone");

        phoneNumber = "5556";

        //the following if statement has to do with transferring the string textTime into a number that can be used
        if (textTime.equals("15 Minutes")) {
            updateInterval = (15 * (60000));
        }else if (textTime.equals("30 Minutes")) {
            updateInterval = (30 * (60000));
        }else if (textTime.equals("1 Hour")){
            updateInterval = (60 * (60000));
        }else {
            updateInterval = (15 * (60000));
        }

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        }else{
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
        }

        //the following method should use a timer to send a sms message in a timed interval. It also should implement using a different thread
        doSomethingRepeatedly();

        return START_STICKY;

    }

    public void doSomethingRepeatedly(){
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                //the following code should be what is done repeatedly
                //Log.d("MessageService", String.valueOf(++counter));

                sendSmsMessage();
            }
        }, 0, updateInterval);
    }

    //the following code handles sending the text message
    public void sendSmsMessage(){
        SmsManager sms = SmsManager.getDefault();
        if (coordinates == null || coordinates.equals("")){
            coordinates = "Could Not Receive Location";
        }

        sms.sendTextMessage(phoneNumber, null, coordinates , null, null);

    }

    public void onDestroy() {
        super.onDestroy();

        if (timer != null) {
            timer.cancel();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        // Called when a new location is found by the network location provider.
        //makeUseOfNewLocation(location);
        lat = (int) (location.getLatitude() * 1E6);
        lng = (int) (location.getLongitude() * 1E6);

        latitude = Integer.toString(lat);
        longitude = Integer.toString(lng);

        coordinates = "Coordinates: " + latitude + ", " + longitude + ". Latitude: " + latitude + " Longitude: " + longitude + ". Respond 'END' to stop texts."; 
    }

    @Override
    public void onProviderDisabled(String provider) {}

    @Override
    public void onProviderEnabled(String provider) {}

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {}
}