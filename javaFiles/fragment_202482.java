class GetDirectionsAsync extends AsyncTask<LatLng, Void, List<LatLng>> {

    JSONParser jsonParser;
    String DIRECTIONS_URL = "https://maps.googleapis.com/maps/api/directions/json";


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<LatLng> doInBackground(LatLng... params) {
        LatLng start = params[0];
        LatLng end = params[1];

        HashMap<String, String> points = new HashMap<>();
        points.put("origin", start.latitude + "," + start.longitude);
        points.put("destination", end.latitude + "," + end.longitude);

        jsonParser = new JSONParser();

        JSONObject obj = jsonParser.makeHttpRequest(DIRECTIONS_URL, "GET", points, true);

        if (obj == null) return null;

        try {
            List<LatLng> list = null;

            JSONArray routeArray = obj.getJSONArray("routes");
            JSONObject routes = routeArray.getJSONObject(0);
            JSONObject overviewPolylines = routes.getJSONObject("overview_polyline");
            String encodedString = overviewPolylines.getString("points");
            list = PolyUtil.decode(encodedString);

            return list;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(List<LatLng> pointsList) {

        if (pointsList == null) return;

        if (line != null){
            line.remove();
        }

        PolylineOptions options = new PolylineOptions().width(5).color(Color.MAGENTA).geodesic(true);
        for (int i = 0; i < pointsList.size(); i++) {
            LatLng point = pointsList.get(i);
            options.add(point);
        }
        line = mMap.addPolyline(options);

    }
}