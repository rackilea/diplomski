Request.Builder builder = new Request.Builder()
        .url(url)
        .addHeader("content-type", "application/json")
        .addHeader("cache-control", "no-cache");
if(type.equals("get")){
    builder.get();
} else if(type.equals("post")){
    builder.post(/*body*/);
}
Request request = builder.build();

Response response = client.newCall(request).execute();