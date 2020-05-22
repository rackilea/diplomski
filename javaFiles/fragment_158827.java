private List<Double> latitudes = new ArrayList<Double>();
private List<Double> longitudes = new ArrayList<Double>();

public void getDistance() {

    // get lat & lon

    Double latitude = Double.parseDouble(latitudeString);
    Double longitude = Double.parseDouble(longitudeString);

    if (latitudes.size() > 0) {
        Double lastLatitude = latitudes.get(latitudes.size() - 1);
        Double lastLongitude = longitudes.get(longitudes.size() - 1);
        // do your calculations
    }

    latitudes.add(latitude);
    longitudes.add(longitude);

}