public void onPostExecute(String json) {

            try {
                // De-serialize the JSON string into an array of branch objects
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObj = jsonArray.getJSONObject(i);

                    LatLng latLng = new LatLng(jsonObj.getDouble("latitude"), jsonObj.getDouble("longitude"));

                    float[] distance = new float[1];
                    LatLng currentLatLng = mCurrLocationMarker.getPosition();

                    //move CameraPosition on user Location
                    if (i == 0) {
                        CameraPosition cameraPosition = new CameraPosition.Builder()
                                .target(currentLatLng).zoom(13).build();

                        map.animateCamera(CameraUpdateFactory
                                .newCameraPosition(cameraPosition));
                    }

                    // Create a marker for each branch in the JSON data.
                    Marker currentMarker = map.addMarker(new MarkerOptions()
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                            .title(jsonObj.getString("name"))
                            .snippet(jsonObj.getString("snippet"))
                            .position(latLng)
                            .visible(false)
                    );

                    Location.distanceBetween(currentLatLng.latitude, currentLatLng.longitude, latLng.latitude, latLng.longitude, distance);

                    if (i == 0) {
                        minDist = distance[0];
                    } else if (minDist > distance[0]) {
                        minDist = distance[0];
                        mClosestMarker = currentMarker;
                    }
                }
                Toast.makeText(NearestBranch.this, "Nearest Branch Distance: "+ mClosestMarker.getTitle() + " " + minDist, Toast.LENGTH_LONG).show();
                map.addMarker(new MarkerOptions()
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                        .title(mClosestMarker.getTitle())
                        .snippet(mClosestMarker.getSnippet())
                        .position(mClosestMarker.getPosition())
                );

            }
            catch (JSONException e) {
                Log.e(LOG_TAG, "Error processing JSON", e);
            }
    }