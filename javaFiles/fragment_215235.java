final class Observation {
    private float gsr;
    private float ibi;

    public Observation(float gsr, float ibi) {
        this.gsr = gsr;
        this.ibi = ibi;
    }

    // getters & setters

}

public final class Observations {
    private final ConcurrentHashMap<Long, Observation> observations = new ConcurrentHashMap<>();

    public void insertGsrValue(long timestamp, float gsr) {
        for (;;) {
            Observation observation = observations.get(timestamp);
            if (observation == null) {
                observation = observations.putIfAbsent(timestamp, new Observation(gsr, 0.0f));
                if (observation == null) {
                    return;
                }
            }
            if (observations.replace(timestamp, observation, new Observation(gsr, observation.getIbi()))) {
                return;
            }
        }
    }

    public void insertIbiValue(long timestamp, float ibi) {
        for (;;) {
            Observation observation = observations.get(timestamp);
            if (observation == null) {
                observation = observations.putIfAbsent(timestamp, new Observation(0.0f, ibi));
                if (observation == null) {
                    return;
                }
            }
            if (observations.replace(timestamp, observation, new Observation(observation.getGsr(), ibi))) {
                return;
            }
        }
    }

    public List<Observation> getObservations() {
        return new ArrayList<>(observations.values());
    }

    public void clear() {
        observations.clear();
    }

}

public final class ObservationService extends Service {
    private final Observations observations = new Observations();
    private volatile long currentMillis;
    private HandlerThread handlerThread;
    private Handler handler;

    @Override
    public void onCreate() {
        super.onCreate();
        handlerThread = new HandlerThread("observations_sender_thread");
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                sendData();
                handler.postDelayed(this, TimeUnit.SECONDS.toMillis(60));
            }
        }, TimeUnit.SECONDS.toMillis(60));
    }

    @Override
    public void onDestroy() {
        handlerThread.quit();
    }

    private void sendData() {
        List<Observation> observationList = observations.getObservations();
        observations.clear();
        // send observation list somehow
    }

    public void didReceiveGSR(float gsr, double timestamp) {
        // assuming this is called on a worker thread
        long t = System.currentTimeMillis() / 1000;
        observations.insertGsrValue(t, gsr);
        currentMillis = t;
    }

    public void didReceiveIBI(float ibi, double timestamp) {
        // assuming this is called on a worker thread
        observations.insertIbiValue(currentMillis, ibi);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}