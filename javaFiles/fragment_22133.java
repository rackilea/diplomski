public interface DatabaseOperationListener {
    public void perform();
    public void onFinish();
}

...


client.post(uploadWebsite, requestParams, new JsonHttpResponseHandler() {
    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONObject response) 
    {
        new DatabaseTask(new DatabaseOperationListener() {
            @Override
            public void perform() {
                DatabaseManager dblocal = DatabaseManager.getInstance();
                dblocal.setAccDetails(Integer.valueOf(acc_iD), acc_nAme, acc_Image, acc_active, acc_priority, acc_creator);

            }

            @Override
            public void onFinish() {
                // do something, perform another request, etc
            }
        }).execute();

   @Override
   public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable error) {
       super.onFailure(statusCode, headers, errorResponse, error);
       // do something
   }
});