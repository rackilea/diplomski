int size = the_json_array.length();
    ArrayList<JSONObject> arrays = new ArrayList<JSONObject>();
    for (int i = 0; i < size; i++) {
      JSONObject another_json_object = the_json_array.getJSONObject(i);
            //Blah blah blah...
            arrays.add(another_json_object);
    }

//Finally
JSONObject[] jsons = new JSONObject[arrays.size()];
arrays.toArray(jsons);

//The end...