@Override
   public void onErrorResponse(VolleyError volleyError) {
   String message = null;
   if (volleyError instanceof NetworkError) {
         message = "Cannot connect to Internet...Please check your connection!";
   } else if (volleyError instanceof ServerError) {
         message = "The server could not be found. Please try again after some time!!";
   } else if (volleyError instanceof AuthFailureError) {
         message = "Cannot connect to Internet...Please check your connection!";
   } else if (volleyError instanceof ParseError) {
         message = "Parsing error! Please try again after some time!!";
   } else if (volleyError instanceof NoConnectionError) {
         message = "Cannot connect to Internet...Please check your connection!";
   } else if (volleyError instanceof TimeoutError) {
         message = "Connection TimeOut! Please check your internet connection.";
   }
}