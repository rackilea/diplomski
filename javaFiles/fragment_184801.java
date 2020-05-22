RequestParams params= new RequestParams();
//params.put("file", new File(filePath));
params.put("file", new File(filePath), contentType);
AsyncHttpClient client = new AsyncHttpClient();
//client.post(url, params, listener);
client.put(url, params, listener);