GeoApiContext gtx = new GeoApiContext().setApiKey("**<<<<your-key-here>>>>**");
try {
    GeocodingResult[] gResp = GeocodingApi.newRequest(gtx).latlng(new LatLng(37, -121)).await();
    System.out.println(gResp[0].formattedAddress);
} catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();