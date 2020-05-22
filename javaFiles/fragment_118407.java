private ArrayList<DataModel> wrapall = new ArrayList<>();

private void parserJson (JSONArray jsonArray){

    try {
        JSONArray array = jsonArray;
        Log.d("jsonarrayishere", array.toString());

        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);

            DataModel dataModel = new DataModel();

            dataModel.setTitle(object.getString("NAME"));
            dataModel.setLatitude(object.get("LATITUDE").toString());
            dataModel.setLongitude(object.get("LONGITUDE").toString());

            //Add data model to array list
            wrapall.add(dataModel);
        }
    } catch (JSONException e) {
        e.printStackTrace();
        Log.d("objectstestwrong", e.getLocalizedMessage());
    }
}