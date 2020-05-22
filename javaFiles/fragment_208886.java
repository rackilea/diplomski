XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();

parser.setInput(new BufferedReader(
                    new InputStreamReader(
                        new URL("http://.....").openConnection().getInputStream()
                    )
                )
            );

while(XmlPullParser.END_DOCUMENT != parser.next()){
    if(XmlPullParser.START_TAG == parser.getEventType()){
        String tagName = parser.getName();
        if(parser.getAttributeCount() > 0 {
             // parse attributes, if needed
        }
        if(parser.nextToken() == XmlPullParser.TEXT){
             String tagValue = parser.getText()
        }
        // etc.
    }
}