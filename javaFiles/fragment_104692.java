final String TAG = "cccc";

try
{
    AssetManager assetManager = createPackageContext(getPackageName(), 0).getAssets();
    XmlResourceParser xml = assetManager.openXmlResourceParser("AndroidManifest.xml");
    int eventType = xml.next();

    while (eventType != XmlPullParser.END_DOCUMENT)
    {
        if (eventType == XmlPullParser.START_DOCUMENT) {
            Log.d(TAG, "START_DOCUMENT");
        } else if(eventType == XmlPullParser.START_TAG) {
            Log.d(TAG, "START_TAG: " + xml.getName());
        } else if(eventType == XmlPullParser.END_TAG) {
            Log.d(TAG, "END_TAG: " + xml.getName());
        } else if(eventType == XmlPullParser.TEXT) {
            Log.d(TAG, "TEXT: " + xml.getText());
        }
        eventType = xml.next();
    }

    xml.close();
}
catch ( XmlPullParserException
      | PackageManager.NameNotFoundException
      | IOException ignore) { }