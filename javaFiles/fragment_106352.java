provider        the name of the provider with which to register
minTime         minimum time interval between location updates, in milliseconds
minDistance     minimum distance between location updates, in meters
listener        a LocationListener whose onLocationChanged(Location) method will be called for each location update

locationmanager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 200, 0, this);