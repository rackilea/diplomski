List<NameValuePair> params = new ArrayList<NameValuePair>();
params.add(new BasicNameValuePair("username", "John"));
params.add(new BasicNameValuePair("password", "pass"));
params.add(new BasicNameValuePair("id", "1"));
params.add(new BasicNameValuePair("name", "John"));
httpPost.setEntity(new UrlEncodedFormEntity(params);