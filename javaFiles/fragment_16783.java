for(int i = 0; i < weatherObservationItems.length(); i++) {
    JSONObject item = weatherObservationItems.getJSONIbject(i);
    String name = item.getString("name");
    String desc = item.getString("description");
    // etc etc
}