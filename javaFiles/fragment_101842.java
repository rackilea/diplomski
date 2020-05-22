public class TestingGroundApp2 {

public static void main(String[] args) throws MalformedURLException, GeneralSecurityException, IOException, ServiceException {
    URL SPREADSHEET_FEED_URL;
    SPREADSHEET_FEED_URL = new URL("https://spreadsheets.google.com/feeds/spreadsheets/private/full/16mMy_UmT1MSJzDMWiQ8gjqRv4d9JPoC8Xwf76URkVqQ");

    File p12 = new File("C:\\Users\\USERNAME\\Desktop\\key.p12");

    HttpTransport httpTransport = new NetHttpTransport();
    JacksonFactory jsonFactory = new JacksonFactory();
    String[] SCOPESArray = {"https://spreadsheets.google.com/feeds", "https://spreadsheets.google.com/feeds/spreadsheets/private/full", "https://docs.google.com/feeds"};
    final List SCOPES = Arrays.asList(SCOPESArray);
    GoogleCredential credential = new GoogleCredential.Builder()
            .setTransport(httpTransport)
            .setJsonFactory(jsonFactory)
            .setServiceAccountId("MYEMAIL_ADDRESS_CREDENTIALS@developer.gserviceaccount.com")
            .setServiceAccountScopes(SCOPES)
            .setServiceAccountPrivateKeyFromP12File(p12)
            .build();

    SpreadsheetService service = new SpreadsheetService("SpreadsheetReader");

    service.setOAuth2Credentials(credential);

    // Make a request to the API and get all spreadsheets.
    SpreadsheetEntry spreadsheet = service.getEntry(SPREADSHEET_FEED_URL,
            SpreadsheetEntry.class);

    System.out.println(spreadsheet.getTitle().getPlainText());

    // Make a request to the API to fetch information about all
    // worksheets in the spreadsheet.
    List<WorksheetEntry> worksheets = spreadsheet.getWorksheets();

    // Iterate through each worksheet in the spreadsheet.
    for (WorksheetEntry worksheet : worksheets) {
        // Get the worksheet's title, row count, and column count.
        String title = worksheet.getTitle().getPlainText();
        int rowCount = worksheet.getRowCount();
        int colCount = worksheet.getColCount();

        // Print the fetched information to the screen for this worksheet.
        System.out.println("\t" + title + "- rows:" + rowCount + " cols: " + colCount);
        // Fetch the list feed of the worksheet.
        URL listFeedUrl = worksheet.getListFeedUrl();
        ListFeed listFeed = service.getFeed(listFeedUrl, ListFeed.class);

        // Iterate through each row, printing its cell values.
        for (ListEntry row : listFeed.getEntries()) {
            // Print the first column's cell value
            System.out.print(row.getTitle().getPlainText() + "\t");
            // Iterate over the remaining columns, and print each cell value
            for (String tag : row.getCustomElements().getTags()) {
                System.out.print(row.getCustomElements().getValue(tag) + "\t");
            }
            System.out.println();
        }

    }

}

}