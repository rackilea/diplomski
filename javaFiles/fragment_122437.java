public int compare(final ThinResult task1, final ThinResult task2) {
        Location location1 = new Location(LocationManager.GPS_PROVIDER);
        Location location2 = new Location(LocationManager.GPS_PROVIDER);
        location1.setLatitude(task1.getLatitude());
        location1.setLongitude(task1.getLongitude());
        location2.setLatitude(task2.getLatitude());
        location2.setLongitude(task2.getLongitude());

        double distanceToPlace1 = mCurrentLocation.distanceTo(location1);
        double distanceToPlace2 = mCurrentLocation.distanceTo(location2);
        return (int) (distanceToPlace1 - distanceToPlace2);
    }