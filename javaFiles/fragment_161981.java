private void checkIn() {
    final RequestQueue requestQueue = Volley.newRequestQueue(Reservations.this);
    final StringRequest stringRequest = new CustomStringRequest(Request.Method.POST, "url", "checkIn",
            (response) -> {
                //Handle response
            },
            (error) -> {
                //Handle error
            });
    int socketTimeOut = 50000;// u can change this .. here it is 50 seconds
    RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
    stringRequest.setRetryPolicy(retryPolicy);
    requestQueue.add(stringRequest);
}