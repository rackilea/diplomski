OkHttpClient client2 = new OkHttpClient();
MediaType mediaType = MediaType.parse("application/json");
RequestBody body = RequestBody.create(mediaType, "{ \"text\" : \"more text"\" }");
            Request request2 = new Request.Builder()
            .url("https://hooks.slack.com/services/********/*********/***************")
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "*/*")
                    .addHeader("Cache-Control", "no-cache")
                    .addHeader("Host", "hooks.slack.com")
                    .addHeader("accept-encoding", "gzip, deflate")
                    .addHeader("Connection", "keep-alive")
                    .addHeader("cache-control", "no-cache")
                    .build();
Response response2 = client2.newCall(request2).execute();