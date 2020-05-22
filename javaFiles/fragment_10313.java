HashMap<String, Object> params = new HashMap<String, Object>();
params.put("neighborhood", "The neighborhood goes here");
ParseCloud.callFunctionInBackground("notifyCrime", params, new FunctionCallback<Object>() {
   void done(Object response, ParseException e) {
       if (e == null) {
          // The users were successfully notified
       }
   }
});