StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://maps.googleapis.com/maps/api/directions/json?origin=START_LOCATION&destination=END_LOCATION&key=API_KEY",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    JSONObject directions;
                    try {
                        directions = new JSONObject(response);

                        JSONArray routes = directions.getJSONArray("routes");

                        mCoordinates = new ArrayList<>();
                        for (int a = 0; a < routes.length(); a++) {
                            JSONObject routesObject = routes.getJSONObject(a);

                            JSONArray legsArray = routesObject.getJSONArray("legs");
                            for (int b = 0; b < legsArray.length(); b++) {
                                JSONObject legsObject = legsArray.getJSONObject(b);
                                JSONArray steps = legsObject.getJSONArray("steps");
                                for (int c = 0; c < steps.length(); c++) {
                                    JSONObject stepsObject = steps.getJSONObject(c);
                                    JSONObject polyLineObject = stepsObject.getJSONObject("polyline");
                                    mCoordinates.addAll(PolyUtil.decode(polyLineObject.getString("points")));
                                }
                            }

                            PolylineOptions routeCoordinates = new PolylineOptions();
                            for (LatLng latLng : mCoordinates) {
                                routeCoordinates.add(new LatLng(latLng.latitude, latLng.longitude));
                            }
                            routeCoordinates.width(5);
                            routeCoordinates.color(Color.BLUE);

                            Polyline route  = mGoogleMap.addPolyline(routeCoordinates);

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            // TODO handle error
        }

    });