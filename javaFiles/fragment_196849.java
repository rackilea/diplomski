public static void deleteTrip(String uniqueID, String city) {

    Key key = getKeyForCity(uniqueID, city);

    datastore.delete(key);

}