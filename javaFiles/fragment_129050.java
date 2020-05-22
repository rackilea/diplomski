StringRequest req = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String data) {
                   // Parse here if you parse the response manually
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    //handle error
                }
            }
    );

    queue.add(req); // Add request to queue