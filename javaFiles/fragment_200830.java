HttpClient httpClient = getHttpClient();

    HttpPost httpost = new HttpPost("https://sample.com/api/posts");
    MultipartEntity mpEntity = new MultipartEntity();
    ContentBody cbFile1 = new FileBody(new File("file.png"), "image/png");
    mpEntity.addPart("image", cbFile1);

    ContentBody cbFile2 = new FileBody(new File("file.svg"), "image/svg+xml");
    mpEntity.addPart("svgz", cbFile2);

    ContentBody cbFile3 = new StringBody(getJsonData().toString(), "application/json", Charset.forName("UTF-8"));
    mpEntity.addPart("json", cbFile3);

    httpost.setEntity(mpEntity);