private final SensorEventListener MultiSensorListener
            = new SensorEventListener() {

    // the overriden methods here ...

    private Map<String, String> map = new HashMap<>();

    private void logHistory(String key, String value) {
        // ...
        // for example:
        map.put(key, value);
    }

    private Map<String, String> getLoggedHistory() {
        Map<String, String> mapCopy = new HashMap<>();
        mapCopy.putAll(map);
        return mapCopy;
    }
    ...
    // Printing of data to screen happens here. File will be written here async.
    @Override
    public void onSensorChanged(SensorEvent event) {
       ...
       // log event:
       map.put(event.getId(), event); // just an example
    }