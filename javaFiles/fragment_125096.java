HttpClient client = HttpClientBuilder.create().build();
    HttpGet get = new HttpGet("http://avisloyalty.eu/assets/fleetlarge//VW_Passat_15.jpg");

    HttpResponse execution = client.execute(get);
    HttpEntity entity = execution.getEntity();
    FileOutputStream outputStream = new FileOutputStream("C:\\tmp\\imgout.jpg");

    if (entity != null) {
        InputStream inputStream = entity.getContent();
        IOUtils.copy(inputStream, outputStream);
    }

    outputStream.close();