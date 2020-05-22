final int cSize = 1024 * 1024; // size of chunk
    File file = new File("path to file");
    final long pieces = file.length()/cSize // used to return file length.

    HttpPost request = new HttpPost(endpoint);

    BufferedInputStream stream = new BufferedInputStream(new FileInputStream(file));

    for (int i= 0; i< pieces; i++) {
        byte[] buffer = new byte[cSize];

        if(stream.read(buffer) ==-1)
          break;

        MultipartEntity entity = new MultipartEntity();
        entity.addPart("chunk_id", new StringBody(String.valueOf(i))); //Chunk Id used for identification.
        request.setEntity(entity);
        ByteArrayInputStream arrayStream = new ByteArrayInputStream(buffer);

        entity.addPart("file_data", new InputStreamBody(arrayStream, filename));

        HttpClient client = app.getHttpClient();
        client.execute(request);
    }