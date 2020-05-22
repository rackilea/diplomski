private static InputStream downloadFile(Drive service, String exportUrl) {
  try {
    HttpResponse resp =
        service.getRequestFactory()
            .buildGetRequest(new GenericUrl(exportUrl))
            .execute();
    return resp.getContent();
  } catch (IOException e) {
    // An error occurred.
    e.printStackTrace();
    return null;
  }
}