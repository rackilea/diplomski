int socketTimeout = 30000; // 30 seconds. You can change it
RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,                 
DefaultRetryPolicy.DEFAULT_MAX_RETRIES,     
DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

postRequest.setRetryPolicy(policy);
AppController.getInstance().addToRequestQueue(postRequest);