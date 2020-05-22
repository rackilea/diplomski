HttpPost httppost = new HttpPost('/createConfigData');
String jsondata = "{\"tailSign\": \"A7ALE\",\"active\": \"Y\"}";
StringEntity jsonparam = new StringEntity(jsondata);
jsonparam.setChunked(true);

httppost.addHeader("content-type", "application/json;charset=UTF-8");
httppost.setEntity(jsonparam);

httpresponse = httpclient.execute(target, httppost);