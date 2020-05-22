///////////////////////////////////////////////////

UrlFetchTransport url = new UrlFetchTransport();

final Books books = new Books.Builder(
    url, jsonFactory, null)
    .setApplicationName(APPLICATION_NAME)
    .setGoogleClientRequestInitializer(
    new GBookRequest()).build();

List volumesList = books.volumes().list("isbn:9780199562855");      

// Execute the query.
Volumes volumes = volumesList.execute();
    if (volumes.getTotalItems() == 0 || volumes.getItems() == null) {
    log.info("No matches found in GBooks.");
    return null;
}

///////////////////////////////////////////////////

public class GBookRequest extends BooksRequestInitializer {

    private static String apiKey = "xxxxxx";

    public GBookRequest() {
    super(apiKey);
    }

    @Override
    public void initializeBooksRequest(BooksRequest  request)
    throws IOException {

    request.set("country", "US");
    }
}

///////////////////////////////////////////////////