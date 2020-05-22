[...]
GeoApiContext context = new GeoApiContext().setApiKey("your-key"); 
GeocodingApiRequest request = GeocodingApi.newRequest(context); 
request.latlng(new LatLng(lat, lon)); 
request.resultType(AddressType.STREET_ADDRESS); 

GeocodingResult[] results = request.await(); // try catch?

for(GeocodingResult r : results){
    for (AddressComponent ac : r.addressComponents) { 
        System.out.println(ac);
    }
}