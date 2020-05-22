Request request = new Request.Builder()
        .url("http://publicobject.com/helloworld.txt")
        .build();

Response response = client.newCall(request).execute();

assert(response.protocol() == Protocol.HTTP_2);