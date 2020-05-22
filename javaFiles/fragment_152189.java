@Override
protected void onPostExecute(String result) {
     try {
        JSONObject jsonObject = new JSONObject(result);

        //Retrieve each Json object's fields
        JSONObject request_id = jsonObject.getJSONObject("result_idcard");
        Double confidence = request_id.getDouble("confidence");

        showAlert(confidence);
     } catch (JSONException e) {
        e.printStackTrace();
     }
}