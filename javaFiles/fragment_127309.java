HttpPost httppost = new HttpPost("some url");

    MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);  
    multipartEntity.addPart("Title", new StringBody("Title"));
    multipartEntity.addPart("Nick", new StringBody("Nick"));
    multipartEntity.addPart("Email", new StringBody("Email"));
    multipartEntity.addPart("Description", new StringBody(Settings.SHARE.TEXT));
    multipartEntity.addPart("Image", new FileBody(image));
    httppost.setEntity(multipartEntity);

    mHttpClient.execute(httppost, new PhotoUploadResponseHandler());