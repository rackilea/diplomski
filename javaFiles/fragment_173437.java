StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {

            try {

                JSONObject jsonObject = new JSONObject(response);

                timestamp = jsonObject.getLong("time");

                lastLoadedDate = new Date(timestamp);

            } catch (JSONException e) {
                //Handle the exception
            }

        }
    }