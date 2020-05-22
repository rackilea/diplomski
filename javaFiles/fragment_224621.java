ArrayList<String> result = new ArrayList<String>();
JSONArray stops = new JSONArray();

for (Entry<String, List<String>> entry : map.entrySet()) {
    String name = entry.getKey();
    List<String> timeEntries = entry.getValue();                        
    try {
        JSONObject stop = new JSONObject();                     
        stop.put("stops_name", name);

        JSONArray timeArray = new JSONArray(timeEntries);
        //arrivalMoFr.put( timeArray);

        JSONObject arrivals = new JSONObject();
        arrivals.put("mon-fri", timeArray);

        stop.put("arrival_time", arrivals);
        stops.put(stop);

        //System.out.println(stops.toString(3));
    } catch (JSONException e) {
        e.printStackTrace();
    }
}