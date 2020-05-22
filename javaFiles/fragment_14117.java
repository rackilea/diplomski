MultipartEntity entity = new MultipartEntity();
        entity.addPart(xml);
        entity.addPart(image);

        httppost.addHeader("Content-Type", "application/soap+xml; charset=\"utf-8\"");
        httppost.setEntity(entity);

        HttpResponse response = httpclient.execute(httppost);