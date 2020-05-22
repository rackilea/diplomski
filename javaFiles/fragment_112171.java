fun Query.getNearestLocation(latitude: Double, longitude: Double, distance: Double): Query {
    // ~1 mile of lat and lon in degrees
    val lat = 0.0144927536231884
    val lon = 0.0181818181818182

    val lowerLat = latitude - (lat * distance)
    val lowerLon = longitude - (lon * distance)

    val greaterLat = latitude + (lat * distance)
    val greaterLon = longitude + (lon * distance)

    val lesserGeopoint = GeoPoint(lowerLat, lowerLon)
    val greaterGeopoint = GeoPoint(greaterLat, greaterLon)

    val docRef = FirebaseFirestore.getInstance().collection("locations")
    return docRef
            .whereGreaterThan("location", lesserGeopoint)
            .whereLessThan("location", greaterGeopoint)
}