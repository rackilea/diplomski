GeoApiContext context = new GeoApiContext().setApiKey("API_KEY");
    GeocodingResult[] results =  GeocodingApi.geocode(context,
            "1600 Amphitheatre Parkway Mountain View, CA 94043").await();
    for (GeocodingResult result : results) {
        System.out.println("LAT: " + result.geometry.location.lat);
        System.out.println("LNG: " + result.geometry.location.lng);
    }