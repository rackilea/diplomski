public class LocationGetter {
    private final Context context;
    private Location location = null;
    private final Cordinate gotLocationLock = new Cordinate();
    private final LocationResult locationResult = new LocationResult() {
        @Override
        public void gotLocation(Location location) {
            synchronized (gotLocationLock) {
                LocationGetter.this.location = location;
                gotLocationLock.notifyAll();
                Looper.myLooper().quit();
            }
        }
    };

    public LocationGetter(Context context) {
        if (context == null)
            throw new IllegalArgumentException("context == null");

        this.context = context;
    }

    public  void getLocation(int maxWaitingTime, int updateTimeout) {
        try {
            final int updateTimeoutPar = updateTimeout;
            synchronized (gotLocationLock) {
                new Thread() {
                    public void run() {
                        Looper.prepare();
                        LocationResolver locationResolver = new LocationResolver();
                        locationResolver.prepare();
                        locationResolver.getLocation(context, locationResult, updateTimeoutPar);
                        Looper.loop();
                    }
                }.start();

                gotLocationLock.wait(maxWaitingTime);
            }
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        gteAddress ();
    }


public double getLatitude() {
    return location.getLatitude();
}

public double getLongitude() {
    return location.getLongitude();
}