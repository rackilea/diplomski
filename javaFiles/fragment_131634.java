//parse json data
try{
    JSONArray jArray = new JSONArray(result);
    for(int i=0;i<jArray.length();i++){
        JSONObject buf = jArray.getJSONObject(i);
        JSONObject json_data = buf.getJSONObject("fields");
        Brete resultRow = new Brete();
        resultRow.contenido = json_data.getString("contenido");
        resultRow.fecha = json_data.getString("fecha");
        resultRow.correo = json_data.getString("correo");
        arrayOfWebData.add(resultRow);
    }
}
catch(JSONException e){
        Log.e("log_tag", "Error parsing data "+e.toString());
}