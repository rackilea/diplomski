@TargetRequestFilter
public void exampleRequestFilter(HttpRequest request) {
    // Authorization header Base64 encoded...
    String encoded = Base64.getEncoder()
            .encodeToString((username + ":" + password).getBytes(StandardCharsets.UTF_8));
    request.addHeader("Authorization", "Basic " + encoded);
}