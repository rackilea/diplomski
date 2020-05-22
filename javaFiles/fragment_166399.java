ParseCloud.callFunctionInBackground("testQuery", params, new FunctionCallback<String>() {
    @Override
    public void done(String results, ParseException e) {
        try { 
            List<String> result = convertToList(results);

        }catch(Exception ex){
            Log.e("Test", "Problem " + ex);
        }
        Log.d("Test", "Done");
    }
});