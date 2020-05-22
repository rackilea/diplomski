public String examplePost(DataObject data) {
        HttpClient httpClient = new DefaultHttpClient();

        try {
            HttpPost httppost = new HttpPost("your url");
            // serialization of data into json
            Gson gson = new GsonBuilder().serializeNulls().create();
            String json = gson.toJson(data);
            httppost.addHeader("content-type", "application/json");

            // creating the entity to send
            ByteArrayEntity toSend = new ByteArrayEntity(json.getBytes());
            httppost.setEntity(toSend);

            HttpResponse response = httpClient.execute(httppost);
            String status = "" + response.getStatusLine();
            System.out.println(status);
            HttpEntity entity = response.getEntity();

            InputStream input = entity.getContent();
            StringWriter writer = new StringWriter();
            IOUtils.copy(input, writer, "UTF8");
            String content = writer.toString();
            // do something useful with the content
            System.out.println(content);
            writer.close();
            EntityUtils.consume(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }