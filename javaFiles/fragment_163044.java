@Multipart
@POST("api/files.upload")
Call<UploadFileResponse> uploadFile(
        @Query("token") String token,
        @PartMap Map<String, RequestBody> params,
        @Query("filetype") String filetype,
        @Query("filename") String filename, @Query("title") String title,
        @Query("initial_comment") String initialComment, @Query("channels") String channels);

    slackApi = new Retrofit.Builder().baseUrl("https://slack.com/").client(new OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(SlackApi.class);


    String str = "Google Places API for Android Samples\n" +
            "===================================\n" +
            "\n" +
            "Samples that use the [Google Places API for Android](https://developers.google.com/places/android/).\n" +
            "\n" +
            "This repo contains the following samples:";
    file = RequestBody.create(MediaType.parse("multipart/form-data"), str.getBytes());

    Map<String, RequestBody> map = new HashMap<>();
    map.put("file\"; filename=\"heapDump.md\"", file);
    call = slackApi.uploadFile(SlackApi.TOKEN, map, "text",
 "heapDump.md", "Test Dump", "Check this out", SlackApi.MEMORY_LEAK_CHANNEL);