if (distance(mylocation.latitude, mylocation.longitude,   location.getLatitude(), location.getLongitude()) < 0.1) { // if distance < 0.1

   //   launch the activity
}else {
   finish();
}


/** calculates the distance between two locations in MILES */
private double distance(double lat1, double lng1, double lat2, double lng2) {

    double earthRadius = 3958.75; // in miles, change to 6371 for kilometers

    double dLat = Math.toRadians(lat2-lat1);
    double dLng = Math.toRadians(lng2-lng1);

    double sindLat = Math.sin(dLat / 2);
    double sindLng = Math.sin(dLng / 2);

    double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
        * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));

    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

    double dist = earthRadius * c;

    return dist;
}