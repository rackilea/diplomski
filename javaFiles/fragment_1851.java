HttpClient httpclient = new DefaultHttpClient();
HttpPost httppost = new HttpPost(url);

FileBody bin = new FileBody(new File(fileName));
StringBody comment = new StringBody("Filename: " + fileName);

MultipartEntity reqEntity = new MultipartEntity();
reqEntity.addPart("bin", bin);
reqEntity.addPart("comment", comment);
httppost.setEntity(reqEntity);

HttpResponse response = httpclient.execute(httppost);
HttpEntity resEntity = response.getEntity();