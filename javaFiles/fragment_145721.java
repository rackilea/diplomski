private List<PlistItem> parse() {
        try {
            InputStream inputStream = MyApplication.getContext().getResources()
                    .openRawResource(R.raw.some);
            XmlPullParserFactory pullParserFactory;
            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = pullParserFactory.newPullParser();
            xmlPullParser.setInput(inputStream, null);

            String key = null;
            PlistItem item = null;
            int eventType = xmlPullParser.getEventType();
            while (!(eventType == XmlPullParser.END_TAG
                    && xmlPullParser.getName() != null
                    && xmlPullParser.getName().equals("plist"))) {

                if (eventType == XmlPullParser.START_DOCUMENT) {
                    list = new ArrayList<>();
                } else if (eventType == XmlPullParser.START_TAG && xmlPullParser.getName().contentEquals(PLIST_ELEMENT_DICT)) {
                    item = new PlistItem();
                } else if (eventType == XmlPullParser.END_TAG && xmlPullParser.getName().contentEquals(PLIST_ELEMENT_DICT)) {
                    list.add(item);
                } else if (eventType == XmlPullParser.START_TAG && xmlPullParser.getName().contentEquals(PLIST_ELEMENT_KEY)) {
                    xmlPullParser.next();
                    key = xmlPullParser.getText();
                } else if (eventType == XmlPullParser.START_TAG && xmlPullParser.getName().contentEquals(PLIST_ELEMENT_STRING)) {
                    xmlPullParser.next();

                    if (key != null && item != null) {
                        if (key.contentEquals(PLIST_VALUE_TYPE)) {
                            item.type = xmlPullParser.getText();
                        }
                        if (key.contentEquals(PLIST_VALUE_SOME)) {
                            item.some.add(xmlPullParser.getText());
                        }
                        if (key.contentEquals(PLIST_VALUE_OTHER_SOME)) {
                            item.otherSome.add(xmlPullParser.getText());
                        }
                    }
                }

                eventType = xmlPullParser.next();
            }

            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }