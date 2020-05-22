Map<Marker, String> markers = new HashMap<Marker, String>();

void createMarkersFromJson(String json) throws JSONException {
    // De-serialize the JSON string into an array of city objects
    JSONObject jObj = new JSONObject(json);
    jsonArray = jObj.getJSONArray("my_array");
    for (int i = 0; i < jsonArray.length(); i++) {
        // Create a marker for each city in the JSON data.
        JSONObject jsonObj = jsonArray.getJSONObject(i);
        time = new Date(jsonObj.getInt("time"));
        calendar.setTime(time);

        htmlString =
                "<div>\n" +
                "            <b>"+jsonObj.getString("name")+"</b>\n" +
                "            <span> - </span>\n" +
                "            <small>\n" +
                "                <a href='http://www.foo.bar/' target='_blank' title='FooBar'>" + "# " +
        jsonObj.getInt("id")+"</a>\n" +
                "            </small>\n" +
                "        </div>\n" +
                "        <div>\n" +
                        getString(R.string.dissapear) + " " + calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND)+"\n</div>\n";

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(new LatLng(
                        jsonObj.getDouble("latitude"),
                        jsonObj.getDouble("longitude")));
        markerOptions.icon(BitmapDescriptorFactory.fromAsset("icons/"+jsonObj.getString("id")+".png"));
        Marker marker = mMap.addMarker(markerOptions);
        markers.put(marker, htmlString);
    }

        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                View v = getLayoutInflater().inflate(R.layout.info_window_layout, null);
                Spanned spannedContent = Html.fromHtml(markers.get(marker));
                TextView html = (TextView) v.findViewById(R.id.html);
                html.setText(spannedContent, TextView.BufferType.SPANNABLE);
                return v;
            }
        });
    Log.e(JSON_TAG, "JSON sucessfully parsed");
}