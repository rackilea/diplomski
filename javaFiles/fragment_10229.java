HttpClient httpclient;
        httpclient = HttpClientSingalTon.getHttpClienttest();
        HttpPost httpPostRequest = new HttpPost(URL);
        // Try This
        httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        MultipartEntity mpEntity = new MultipartEntity();
        ContentBody cbFile = new FileBody(yourimagefile, "image/jpeg");
        mpEntity.addPart("file", cbFile); 
        httpPostRequest.setEntity(mpEntity);
        HttpResponse response = (HttpResponse) httpclient.execute(httpPostRequest);