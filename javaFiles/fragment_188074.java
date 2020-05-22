String responseResult = null;
try {
    Log.d(TAG, response.body().contentType()+"");
    BufferedSource source = response.body().source();
    source.request(Long.MAX_VALUE); // Buffer the entire body.
    Buffer buffer = source.buffer();
    responseResult = buffer.clone().readString(Charset.forName("UTF-8"));
    Log.d(TAG, "result: "+responseResult);
}catch(Exception e){
    // TODO
}