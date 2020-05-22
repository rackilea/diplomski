RequestBody requestBody = new MultipartBody.Builder()
        .setType(MultipartBody.FORM)
        .addFormDataPart("somParam", "someValue")
        .build();

Request request = new Request.Builder()
        .url(BASE_URL + route)
        .post(requestBody)
        .build();