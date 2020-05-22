HashMap<String, Object> params = new HashMap<String, Object>();
    params.put("userId",userId);
    ParseCloud.callFunctionInBackground("myFunction", params, new FunctionCallback<String>() {
        public void done(String res,ParseException e){
            if (e == null) {
                Log.i("Results :",res);
            } else {
                Log.i("Error",e.getMessage());
            }
        }
    });