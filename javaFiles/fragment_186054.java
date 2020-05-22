HashMap<String,Long> beaconDetections = new HashMap<String,Long>();

public void didRangeBeaconsInRegion(Region region, Collection<Beacon> beacons) {
  Long now = System.currentTimeMillis();
  for (Beacon beacon : beacons) {
    Long firstDetectionTime = beaconDetections.get(beacon.toString());
    if (firstDetectionTime != null) {
      if (now-firstDetectionTime > 30000l) {
        // Put logic here for if beacon seen for 30 secs or more
      }
    }
    else {
      beaconDetections.put(beacon.toString(), now);   
    }
  }
}