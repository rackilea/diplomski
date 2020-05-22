private void pullParserSample(FileInputStream xml) {
    int lists = 0;
    int notes = 0;
    int eventType = -1;

    try {
        XmlPullParser xpp = XmlPullParserFactory.newInstance().newPullParser();
        xpp.setInput(new InputStreamReader(xml));

        eventType = xpp.getEventType();

        do {
            switch ( eventType ) {

            case XmlPullParser.START_TAG:
                final String tag = xpp.getName();
                if ( "Note".equals(tag) ) {
                    notes++;
                }
                else if ( "List".equals(tag) ) {
                    lists++;
                }
                break;

            }

        } while ((eventType = xpp.next()) != XmlPullParser.END_DOCUMENT) ;

    } catch (XmlPullParserException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    Log.d(TAG, "lists=" + lists + " notes=" + notes);
}