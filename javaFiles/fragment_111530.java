public void checkIfSongPurhcased(final String songName, final OnQueryResultCallback listener){
    OkHttp3Connection.doOkHttp3Connection("", Services_Url_class.GET_SONG_PURCHASED, OkHttp3Connection.Request_type.POST, request_data, new OkHttp3Connection.OkHttp3RequestCallback() {
                @Override
                public void onSuccess(String result, String userTag) throws JSONException {
                    JSONObject jsonResult = new JSONObject(result);
                    JSONArray data = jsonResult.getJSONArray("data");
                    if(data != null) {
                        String[] names = new String[data.length()];
                        for(int i = 0 ; i < data.length() ; i++) {
                            JSONArray arr = data.getJSONArray(i);
                            JSONObject dataObj = arr.getJSONObject(0);
                            Iterator<String> keys = dataObj.keys();
                            names[i] = dataObj.getString(keys.next());
                        }

                        //names[0] is "true"
                        boolean status = Boolean.parseBoolean(names[0]);
                        listener.onQueryResult(songName,status);
                    }
                }
                @Override
                public void onError(String error, String userTag) {
                    System.out.println("songy" + error);
                    listener.onQueryResult(songName,false);
                }
            }
    );
}