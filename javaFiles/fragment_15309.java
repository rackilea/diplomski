public String httpOperation(String conversion, String fileName) {

    HttpClient httpclient = new DefaultHttpClient();
    try {
        // url parameters
        MultipartEntityBuilder multipartEntity = MultipartEntityBuilder
                .create();
        // add html tags param
        multipartEntity.addTextBody("conversion", conversion,
                ContentType.TEXT_PLAIN);
        multipartEntity.addTextBody("language", EN, ContentType.TEXT_PLAIN);
        multipartEntity.addTextBody("outputmode", TEXT,
                ContentType.TEXT_PLAIN);
        multipartEntity.addTextBody("coding", UTF, ContentType.TEXT_PLAIN);

        // add files as attachments
        multipartEntity.addPart("sourcefile", new FileBody(new File(
                fileName), ContentType.TEXT_PLAIN, "filename"));

        multipartEntity.setBoundary(PARAM_BOUNDARY);

        HttpEntity postEntity = multipartEntity.build();

        HttpPost httpPost = new HttpPost(URL);
        httpPost.setHeader("Content-Disposition", "form-data;");
        httpPost.setEntity(postEntity);

        // get response after execution
        HttpResponse response = httpclient.execute(httpPost);

        // get response entities
        HttpEntity resEntity = response.getEntity();

        if (resEntity != null) {
            @SuppressWarnings("deprecation")
            String responseBody = EntityUtils.toString(resEntity,
                    HTTP.UTF_8);
            // print output
            if (conversion.equals(TRUE)) {
                extractResponse(responseBody.toString());
                // System.out.println(responseBody.toString());
                result = responseBody.toString();
            } else {
                // System.out.println(responseBody.toString());
                result = responseBody.toString();
            }
        }
        EntityUtils.consume(resEntity);

    } catch (Exception err) {
        System.err.println(err.toString());
    } finally {
        // close connection
        httpclient.getConnectionManager().shutdown();
    }

    return result;
}