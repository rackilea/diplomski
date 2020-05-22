// somewhere globally defined
private final MetricRegistry metrics = new MetricRegistry();
private final Meter requests = metrics.meter("requests");

// the method to be metered
public void run() {
    requests.mark();
    // do stuff
}