public class ResponseBodyUrlRewriteTransformer extends ResponseTransformer {

  final int wiremockPort;
  final String wiremockBindAddress;
  final private List<String> urlsToReplace;

  public ResponseBodyUrlRewriteTransformer(String wiremockBindAddress, int wiremockPort, List<String> urlsToReplace) {
    this.urlsToReplace = urlsToReplace;
    this.wiremockBindAddress = wiremockBindAddress;
    this.wiremockPort = wiremockPort;
  }

  private String replaceUrlsInBody(String bodyText) {
    for (String urlToReplace : urlsToReplace) {
      bodyText = bodyText.replaceAll(Pattern.quote(urlToReplace),
          "http://" + wiremockBindAddress + ":" + wiremockPort);
    }
    return bodyText;
  }

  @Override
  public Response transform(Request request, Response response, FileSource files, Parameters parameters) {
    if (response.getStatus() == 200) {
      ContentTypeHeader contentTypeHeader = response.getHeaders().getContentTypeHeader();
      if (contentTypeHeader != null && contentTypeHeader.mimeTypePart().contains("xml")) {
        return Response.response()
            .body(replaceUrlsInBody(response.getBodyAsString()))
            .headers(response.getHeaders())
            .status(response.getStatus())
            .statusMessage(response.getStatusMessage())
            .fault(response.getFault())
            .chunkedDribbleDelay(response.getChunkedDribbleDelay())
            .fromProxy(response.isFromProxy())
            .build();
      }
    }
    return response;
  }

  @Override
  public String getName() {
    return "ResponseBodyUrlRewriteTransformer";
  }
}