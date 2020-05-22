private void drawChart() {

    String tag_string_req = "req_chart";

    StringRequest strReq = new StringRequest(Request.Method.POST, "YOUR URL",
            new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {

                    Log.d(TAG, "Response: " + response);

                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        String id = jsonObject.getString("id");
                        JSONArray jsonArray = jsonObject.getJSONArray("measurements");
                        for (int i = 0; i < jsonArray.length(); i++) {

                            int value = jsonObject.getInt("value");
                            String date = jsonObject.getString("time");
                            x.add(new Entry(value, i));
                            y.add(date);

                        }
                        LineDataSet set1 = new LineDataSet(x, "NAV Data Value");
                        set1.setLineWidth(1.5f);
                        set1.setCircleRadius(4f);
                        LineData data = new LineData(y, set1);
                        mChart.setData(data);
                        mChart.invalidate();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {

        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e(TAG, "Error: " + error.getMessage());
        }
    });
    strReq.setRetryPolicy(new RetryPolicy() {

        @Override
        public void retry(VolleyError arg0) throws VolleyError {
        }

        @Override
        public int getCurrentTimeout() {
            return 0;
        }

        @Override
        public int getCurrentRetryCount() {
            return 0;
        }
    });
    strReq.setShouldCache(false);
    AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
}