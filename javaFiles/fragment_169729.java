/*
        *For Pdf ->MediaType.parse("file/pdf")
        *For Video-> MediaType.parse("video/mp4")
        *For Image-> MediaType.parse("image/png")
        */
        final MediaType MEDIA_TYPE_PNG=MediaType.parse("audio/mp3");
        final OkHttpClient client =new OkHttpClient();


        RequestBody requestBody = new MultipartBody.Builder()
          .setType(MultipartBody.FORM)
          .addFormDataPart("filedata", "file_name.extension", RequestBody.create(MEDIA_TYPE_PNG, new File("path_of_file")))
          .addFormDataPart("recipient","{\"id\":\"USER_ID\"}")
          .addFormDataPart("message", "{\"attachment\":{\"type\":\"TYPE_OF_FILE\", \"payload\":{}}}")//as in Facebook Docs
          .build();

      Request request = new Request.Builder()
          .url("https://graph.facebook.com/v2.6/me/messages?access_token=ACCESS_TOKEN")
          .post(requestBody)
          .build();


      Response response = client.newCall(request).execute();

      System.out.println(response.body().string());