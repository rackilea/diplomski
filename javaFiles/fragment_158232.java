Map<String,String> params = new HashMap<>();
        StringRequest request = new VolleyStringRequest(Request.Method.POST,"https://google.com", new VolleyStringRequest.ResponseListener() {
            @Override
            public void onResponse(String response, List<Header> headers) {
//here you get all the headers. do whatever you want with it
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        },params).getRequest();
      queue.add(request);