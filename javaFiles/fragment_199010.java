OkHttpClient client = new OkHttpClient();

MediaType mediaType = MediaType.parse("application/octet-stream");
RequestBody body = RequestBody.create(mediaType, "{\n        \"userId\": 100,\n        \"id\": 100,\n        \"title\": \"main title\",\n        \"body\": \"main body\"\n    }");
Request request = new Request.Builder()
  .url("https://jsonplaceholder.typicode.com/posts")
  .post(body)
  .addHeader("cache-control", "no-cache")
  .addHeader("postman-token", "e11ce033-931a-0419-4903-ab860261a91a")
  .build();

Response response = client.newCall(request).execute();