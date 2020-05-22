public class XmlParser {
static final String KEY_SITE = "rate";

static final String KEY_NAME = "Name";

static final String KEY_LINK = "Rate";

static final String KEY_ABOUT = "Date";

static final String KEY_IMAGE_URL = "Time";

FileInputStream fis;


public static List<HandleXML> getStackSitesFromFile() {
    // List of StackSites that we will return

    List<HandleXML> stackSites;

    stackSites = new ArrayList<HandleXML>();

    // temp holder for current StackSite while parsing

    HandleXML curStackSite = null;

    // temp holder for current text value while parsing

    String curText = "";
    try {

        // Get our factory and PullParser

        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();

        XmlPullParser xpp = factory.newPullParser();
        // Open up InputStream and Reader of our file.

        fis =  new FileInputStream(new File("/sdcard/rates.xml"));

        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        // point the parser to our file.

        xpp.setInput(reader);
        // get initial eventType

        int eventType = xpp.getEventType();
        // Loop through pull events until we reach END_DOCUMENT

        while (eventType != XmlPullParser.END_DOCUMENT) {

            // Get the current tag

            String tagname = xpp.getName();
            // React to different event types appropriately

            switch (eventType) {

            case XmlPullParser.START_TAG:

                if (tagname.equals("test")) {
                    curStackSite = new HandleXML();
                }
                break;
            case XmlPullParser.TEXT:
                //grab the current text so we can use it in END_TAG event
                curText = xpp.getText();
                break;
            case XmlPullParser.END_TAG:
                if (tagname.equalsIgnoreCase("test")) {
                    stackSites.add(curStackSite);
                } else if (tagname.equalsIgnoreCase(KEY_NAME)) {
                    curStackSite.setName(curText);
                } else if (tagname.equals("Rate")) {
                    curStackSite.setLink(curText);
                } else if (tagname.equalsIgnoreCase(KEY_ABOUT)) {
                    curStackSite.setAbout(curText);
                } else if (tagname.equalsIgnoreCase(KEY_IMAGE_URL)) {
                    curStackSite.setImgUrl(curText);
                }
                break;
            default:
                break;
            }
            eventType = xpp.next();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    try {
        fis.close();
    }catch(Exception e){
        Log.i("Problem closing", "Closing fis");
    }


    // return the populated list.
    return stackSites;
}
}