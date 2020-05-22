for (int position = 0; position < jaLocalstreams.length(); position++) {
    JSONObject JO = jaLocalstreams.getJSONObject(position);
    cityString += JO.getString("City");
    stateString += JO.getString("State");
}

citiess.setText("" + cityString);
statess.setText("" + stateString);