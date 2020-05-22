boolean done = false;
while (!done) {

    if (eventType == XmlPullParser.START_TAG) {

        if (parser.getName().equals("query")) {
            done = true;
        } else if  (parser.getName().equals("item")) {
            Map<String,String> attributes = getAttributes(parser);
        }
    }
    else if (eventType == XmlPullParser.END_TAG) {

    }
    int eventType = parser.next();
}