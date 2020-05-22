XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
    factory.setNamespaceAware(true);
    XmlPullParser xpp = factory.newPullParser();
    boolean inLineTag = false;
    StringBuilder strBldr = new StringBuilder();
    xpp.setInput(new StringReader(
            "<line> I like cookies <u>Do you like them too?</u> </line>"));
    int eventType = xpp.getEventType();
    while (eventType != XmlPullParser.END_DOCUMENT) {
        if (eventType == XmlPullParser.START_TAG) {
            if(("line").equals(xpp.getName())){
                inLineTag = true;
            }
        } else if (eventType == XmlPullParser.END_TAG) {
            if(("line").equals(xpp.getName())){
                inLineTag = false;
            }
        } else if (eventType == XmlPullParser.TEXT) {
            if (inLineTag) {
                strBldr.append(xpp.getText());
            } 
        }
        eventType = xpp.next();
    }

    System.out.println("Text " + strBldr.toString());
}