@Override
public void onResponse(Call call, Response response) throws IOException {
     final String responseData = response.body().string();

     if (responseData != null) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(responseData, JsonElement.class);
        JsonObject jsonObject = element.getAsJsonObject();
        final AccessRequest request = gson.fromJson(jsonObject, AccessRequest.class);

        recentAppName = request.AppName.toString();
        recentRequestTime = request.RequestTime.toString();
        if (request.IsExpired)
            isExpired = "Has Expired";
        else isExpired = "Active";

        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
               //Handle UI here                        
               tvRecentAppName.setText(recentAppName);
               tvRecentRequestTime.setText(recentRequestTime);
               tvIsExpired.setText(isExpired);                
            }
       });
    }
}