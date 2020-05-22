String sheetURL = "XXXXXX@XXXXXX-XXXX.iam.gserviceaccount.com";
HttpTransport httpTransport = new NetHttpTransport();
JacksonFactory jsonFactory = new JacksonFactory();
String[] SCOPESArray = {"https://spreadsheets.google.com/feeds", "https://spreadsheets.google.com/feeds/spreadsheets/private/full", "https://docs.google.com/feeds"};

final List SCOPES = Arrays.asList(SCOPESArray);
GoogleCredential credential = null;
InputStream stream = null;
File tempFile = null;

try {
    stream = this.getClass().getClassLoader().getResourceAsStream("authentication/key.p12");
    tempFile = File.createTempFile("temp", "temp");
    IOUtils.copy(stream, new FileOutputStream(tempFile));
}
catch (IOException e) {
    print(e.toString());
}
finally {
    if (stream != null) {
        IOUtils.closeQuietly(stream);
    }
}

credential = new GoogleCredential.Builder()
    .setTransport(httpTransport)
    .setJsonFactory(jsonFactory)
    .setServiceAccountId(sheetURL)
    .setServiceAccountScopes(SCOPES)
    .setServiceAccountPrivateKeyFromP12File(tempFile) 
    .build();