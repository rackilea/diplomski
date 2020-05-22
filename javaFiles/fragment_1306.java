private void caladata() {

    // showing refresh animation before making http call
    swipeRefreshLayout.setRefreshing(false);

    // Volley's json array request object
    StringRequest stringRequest = new StringRequest(Request.Method.POST, CALENDAR_DATA,
            new Response.Listener < String > () {
                @Override
                public void onResponse(String response) {
                    //                        Log.d(TAG, response.toString());
                    //                        hidePDialog();
                    JSONObject object = null;
                    try {
                        object = new JSONObject(response);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    JSONArray jsonarray = null;

                    try {
                        jsonarray = object.getJSONArray("Table");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    calList = new ArrayList<>();

                    for (int i = 0; i < jsonarray.length(); i++) {
                        try {
                            JSONObject obj = jsonarray.getJSONObject(i);

                            Calenndar_Model movie = new Calenndar_Model();
                            movie.setUserid(obj.getString("userid"));
                            movie.setHost(obj.getString("eventname"));

                            String str = obj.getString("eventdate").replaceAll("\\D+","");
                            String upToNCharacters = str.substring(0, Math.min(str.length(), 13));
                            DateFormat timeZoneFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                            timeZoneFormat.setTimeZone(TimeZone.getTimeZone("GMT-8"));

                            Date time = new Date(Long.parseLong(upToNCharacters));
                            //System.out.println(time);
                            movie.setDate(String.valueOf(timeZoneFormat.format(time)));
                            movie.setColor(obj.getString("eventcolor"));
                            movie.setAutoid(obj.getString("autoid"));

                            //Toast.makeText(getApplicationContext(), "server data respone", Toast.LENGTH_LONG).show();
                            calList.add(movie);

                        }  catch (JSONException e) {
                            // Log.e(TAG, "JSON Parsing error: " + e.getMessage());
                        }

                    }

                    //sort calList list 
                    Comparator<Calenndar_Model> calendarModelComparator = new Comparator<Calenndar_Model>() {
                        @Override
                        public int compare(Calenndar_Model cm1, Calenndar_Model cm2) {
                            boolean firstContainsData2 = calendarModelContainsData2(cm1);
                            boolean secondContainsData2 = calendarModelContainsData2(cm2);
                            if (firstContainsData2 && secondContainsData2) {
                                return 0;
                            } else if (firstContainsData2) {
                                return -1;
                            } else if (secondContainsData2) {
                                return 1;
                            } else return cm2.getData().compareTo(cm1.getData());
                        }

                        private boolean calendarModelContainsData2(Calenndar_Model cm) {
                             return cm.getData().contains(data2);
                        }
                    };
                    Collections.sort(calList, calendarModelComparator);


                    // notifying list adapter about data changes
                    // so that it renders the list view with updated data
                    adapter.swapList(calList);
                    //listView.smoothScrollToPositionFromTop(selectedPos,0,300);

                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            //                VolleyLog.d(TAG, "Error: " + error.getMessage());
            //                hidePDialog();

        }
    }) {
        @Override
        protected Map < String, String > getParams() {
            Map < String, String > params = new HashMap < String, String > ();
            params.put("clientid", get1);
            return params;
        }
    };
    // Adding request to request queue
    MyApplication.getInstance().addToRequestQueue(stringRequest);
}