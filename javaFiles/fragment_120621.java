// Encoding
List<LatLng> locations2Encode = new ArrayList<LatLng>();
locations2Encode.add(new LatLng(40.1d, -3.1d));
locations2Encode.add(new LatLng(40.2d, -3.2d));
locations2Encode.add(new LatLng(40.3d, -3.3d));
locations2Encode.add(new LatLng(40.4d, -3.4d));
String encodedPolyline = PolyUtil.encode(locations2Encode);

// Decoding
List<LatLng> locations = PolyUtil.decode(encodedPolyline);