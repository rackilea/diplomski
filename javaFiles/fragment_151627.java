@Override
                public void success(PositionResponse positionResponse, Response response) {
                    position_w3w.setText(Arrays.toString(positionResponse.getPosition()).replaceAll("\\[|\\]", ""));
                    //Log.d("w3w location: ", Arrays.toString(positionResponse.getPosition()));
                    String mLatLng = Arrays.toString(positionResponse.getPosition()).replaceAll("\\[|\\]", "");

                    String[] arrLatLng = mLatLng.split(","); //separate out lat and lon
                    LatLng latLon = new LatLng(Double.parseDouble(arrLatLng[0]), Double.parseDouble(arrLatLng[1])); //create the LatLng object

                    //Convert String to double
                    //double value = Double.parseDouble(mLatLng); this wouldn't work, you need to do both values individually
                    //Set marker to map, use LatLng object latLon
                    mGoogleMap.addMarker(new MarkerOptions().position(latLon)
                            .title("Geolocation system")
                            .snippet("Your last current location which was available!")
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_location)));

                     CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(latLon).zoom(12).build();


                     mGoogleMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));
                }