JsonObjectRequest jsonObjReq = new JsonObjectRequest(Method.GET, urlJsonObj, null, new Response.Listener<JSONObject>() {
     @Override
     public void onResponse(JSONObject response) {
         List<String> nodeIds = new ArrayList<String>();
         for (String key : response.keySet()) {
             JSONObject entry = response.getJSONObject(key);
             nodeIds.add(enty.getJSONObject("basic").getString("node_id"));
         }
         txtResponse.setText(ListUtils.toString(nodeIds)); //from apaches commons library
     }
}