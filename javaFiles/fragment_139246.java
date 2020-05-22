parser.require(XmlPullParser.START_TAG, ns, "mojiva");
   while (parser.next() != XmlPullParser.END_TAG) {
       if (parser.getEventType() != XmlPullParser.START_TAG) {
           continue;
       }
       String name = parser.getName();
       if (name.equals("string")) {
           String relType = parser.getAttributeValue(null, "href");
           Log.i("....................","Hello......"+relType);

       } else {
           skip(parser);
       }
   }