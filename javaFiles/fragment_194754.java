protected String videoSourceFromDocument(final Document document) {
    final List<String> hrefs = ...;
    return hrefs.stream()
                .flatMap(href -> this.videoDownloaders.stream()
                                     .filter(d -> d.support(href))
                                     .map(d -> d.videoFromUrl(href)))
                .findFirst()
                .orElseThrow(() -> {
                    this.logger().warn("Url {} doesn't has video source", document.baseUri());
                    return new IllegalArgumentException();
                });
}