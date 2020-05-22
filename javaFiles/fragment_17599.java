public void testSendText() throws JSONException {       
        JSONObject jsonObj = new JSONObject(jsonString);
        JSONArray  jsonArr = jsonObj.getJSONArray("A"); //get array A

        Vector<Point> apoints = new Vector<Point>();
        for(int k = 0; k < jsonArr.length(); k++ ){
            JSONArray arr = jsonArr.getJSONArray(k);
            apoints.add(new Point(arr.getInt(0), arr.getInt(1)));
        }
        getUiDevice().swipe(apoints.toArray(new Point[apoints.size()]), 5);
}