DefaultHttpClient httpClient = new DefaultHttpClient();
//String paramString = URLEncodedUtils.format(params, HTTP.UTF_8);

String unicodeUrl = URLEncoder.encode(url += "?" + params, "UTF-8");
Log.d("URL" , unicodeUrl);
HttpGet httpGet = new HttpGet(unicodeUrl);

HttpResponse httpResponse = httpClient.execute(httpGet);

HttpEntity httpEntity = httpResponse.getEntity();
is = httpEntity.getContent();