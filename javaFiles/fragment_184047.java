IBeaconFilter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_scanner);
        distanceTV = findViewById(R.id.distanceText);
        fillBeaconList(listOfHardcodedBeacons);
        randint = random.nextInt(listOfHardcodedBeacons.size());
        filter = new IBeaconUniqueIdFilter(listOfHardcodedBeacons.get(randint).getUniqueId());

        setupProximityManager();

        super.onCreate(savedInstanceState);
    }

private void setupProximityManager(){
        proximityManager = ProximityManagerFactory.create(this);

        //configure proximity manager basic options
        proximityManager.configuration()
                //using ranging for continuous scanning or MONITORING for scanning with intervals
                .scanPeriod(ScanPeriod.RANGING)
                //using BALANCED for best performance/battery ratio
                .scanMode(ScanMode.LOW_LATENCY)
                //OnDeviceUpdate callback will be received with 1 second interval
                .deviceUpdateCallbackInterval(TimeUnit.MILLISECONDS.toMillis(20));

        //setting up iBeacon and Eddystone spaces listeners
        //proximityManager.setSpaceListener(createSpaceListener());

        //setting up iBeaconListener to only listen for random beacon (filter)
        proximityManager.filters().iBeaconFilter(filter);
        proximityManager.setIBeaconListener(createIBeaconListener());
        proximityManager.setEddystoneListener(new SimpleEddystoneListener() {
        });

    }