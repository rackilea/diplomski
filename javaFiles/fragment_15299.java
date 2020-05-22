public static final String DEF_GCS_BUCKET_NAME = PROJECT_ID + ".appspot.com";

public static final String FIRESTORE_API_V1BETA2 =
        "https://firestore.googleapis.com/v1beta2";

public static final String FIRESTORE_DB = "/projects/" + PROJECT_ID
        + "/databases/(default)";

public static final String FIRESTORE_EXPORT_GCS_LOC = "gs://"
        + DEF_GCS_BUCKET_NAME + "/firestore-export/";

public static final String FIRESTORE_EXPORT_GCS_ROOT = "firestore-export/";

private static final String FUNC_EXPORT_DOCUMENTS = ":exportDocuments";

@javax.annotation.CheckForNull
public static Operation exportCollectionToGcs(@lombok.NonNull String collection)
        throws IOException {

    AccessToken token = tokenFor(serviceAc());
    Map<String, Object> payload = new HashMap<>();
    payload.put("collectionIds", Arrays.asList(collection));
    payload.put("outputUriPrefix", FIRESTORE_EXPORT_GCS_LOC + collection);

    GenericUrl url = new GenericUrl(FIRESTORE_API_V1BETA2 + FIRESTORE_DATABASE
        + FUNC_EXPORT_DOCUMENTS);
    HttpContent content = new JsonHttpContent(jacksonFactory(), payload);
    HttpRequest req = requestFactory().buildPostRequest(url, content);
    req.getHeaders().setAuthorization("Bearer " + token.getTokenValue())
    Operation op = null;
    try {
        HttpResponse res = req.execute();
        // Parse the response JSON to populate an Operation POJO
    } catch (HttpResponseException e) {
        // Handle the error
    }
    return op;
}