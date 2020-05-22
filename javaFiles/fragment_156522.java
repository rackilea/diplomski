HttpParams params = new BasicHttpParams();
for(BasicNameValuePair postValue: postValues) {
    params.setParameter(postValue.getName(), postValue.getValue());
}

HttpPost post = new HttpPost();
post.setParams(params);

MultipartEntity entity = new MultipartEntity();
entity.addPart("file", new FileBody(new File(myFile)));
post.setEntity(entity);