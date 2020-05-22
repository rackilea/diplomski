public void updateUserLocation(final Location location) {
        if (location.getLatitude()!=null && location.getLongitude()!=null)
        {
        lat = location.getLatitude();
        lng = location.getLongitude();
        }

}