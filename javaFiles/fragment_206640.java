HttpResponse response = httpClient.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        HttpEntity entity = response.getEntity();
        responseBody = entity.getContent();

        if (statusCode != 200) {
            // responseBody will have the error response
        }