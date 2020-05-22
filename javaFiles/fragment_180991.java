...
ListenerMonitor listenerMonitor = new ListenerMonitor(...);
...
public boolean handleMessage(Message msg) {
    if (msg.what == StartMeasurementCmd) {
        Log.d(TAG, "Starting measurement");
        ... = listenerMonitor.readSensor(...);
        Log.d(TAG, "Measurement finished");