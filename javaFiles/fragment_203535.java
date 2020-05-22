private CityNode getLowestDistanceCity(Set <CityNode> unsettledCities) {
    CityNode lowestDistanceCity = null;
    int lowestDistance = Integer.MAX_VALUE;
    for (CityNode city: unsettledCities) {
        int nodeDistance = distances.get(city);
        if (nodeDistance < lowestDistance) {
            lowestDistance = nodeDistance;
            lowestDistanceCity = city;
        }
    }
    return lowestDistanceCity;
}