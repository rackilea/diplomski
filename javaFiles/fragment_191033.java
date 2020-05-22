private class AddAsyncTask extends AsyncTask<String, Void, JSONOnject>
 {
     JSONObject jsonObjRecv;
     String result;

@Override
protected JSONObject doInBackground(String... params) {
    AssetObj assetObj = new AssetObj();
    assetObj.setAssetName(txtname.getText().toString());
    assetObj.setMobileNo(txtmobile.getText().toString());
    assetObj.setOwnerId(myApp.getOwnerId());
    assetObj.setStartTime(startTime.getText().toString());
    assetObj.setEndTime(endTime.getText().toString());
    assetObj.setInterval(interval.getText().toString());
    JSONObject jsonObjRecv = SyncService.AddNewAssetRequest(assetObj);
 }
 protected void onPostExecute(JSONObject obj){
            if(obj != null)
            {
                //do something
            }