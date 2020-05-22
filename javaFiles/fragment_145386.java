try {
    for (PlacesSearchResult result : sortedPoints) {
        PlaceDetailsRequest placeDetailsRequest = 
            new PlaceDetailsRequest(geoApiContext);
        placeDetailsRequest.placeId(result.placeId);
        PlaceDetails placeDetails = placeDetailsRequest.await();
        objectOfInterests.add(convert(placeDetails));
    }
} catch (Exception e) {
    e.printStackTrace();
}