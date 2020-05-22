import org.apache.http.client.utils.URIBuilder;

// ...

URIBuilder b = new URIBuilder("http://example.com");
b.addParameter("t", "search");
b.addParameter("q", "apples");

Url url = b.build().toUrl();