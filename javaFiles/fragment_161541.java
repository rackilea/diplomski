public StreamedContent downloadFile() {
      // convert GSON object to InputStream
      String gson= json.getJSONObject("data").toString();
      InputStream stream = new ByteArrayInputStream(gson.getBytes());

      DefaultStreamedContent  content = new DefaultStreamedContent(stream,
                  MediaType.APPLICATION_JSON,
                  "test.json");

      return content;
   }