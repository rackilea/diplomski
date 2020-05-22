private void parseJson(JSONObject jsonObject, String objName){

    try {

        for(int i = 0; i < jsonObject.length(); i++){


            if(jsonObject.get(jsonObject.names().getString(i)) instanceof JSONObject){

                JSONObject  singleObj = new JSONObject(jsonObject.get(jsonObject.names().getString(i)).toString());

                Iterator<String> keys= singleObj.keys();
                while (keys.hasNext()){

                    String keyValue = keys.next();
                    final String valueString = singleObj.getString(keyValue);

                    if(!isJSONObjectOrString(valueString)){

                        if(keyValue.contains(objName) || valueString.contains(objName)
                                || jsonObject.names().getString(i).contains(objName)){
                            Log.e("objectName", jsonObject.names().getString(i));
                            Log.e(keyValue, valueString);
                        }

                    }

                }

                parseJson(singleObj);
            }
        }

    } catch (JSONException e) {
        e.printStackTrace();
    }

}