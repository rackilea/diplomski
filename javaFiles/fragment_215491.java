public void xmlParse(String file) throws XmlPullParserException, IOException {
        Log.i("String", "going in xml parse");
        boolean demoflag = false;
        Data d = null;

        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser xpp = factory.newPullParser();

        xpp.setInput(new StringReader(file));
        int eventType = xpp.getEventType();

        while (eventType != XmlPullParser.END_DOCUMENT) {
            Log.i("String", "in while");
            switch (eventType) {
            case XmlPullParser.START_DOCUMENT:
                break;

            case XmlPullParser.START_TAG:
                if (xpp.getName().equalsIgnoreCase("country")) {
                    demoflag = true;
                }
                break;
            case XmlPullParser.TEXT:
                if (demoflag) {
                    Log.i("country", "" + xpp.getText().trim());
                }
                break;
            case XmlPullParser.END_TAG:
                if (xpp.getName().equalsIgnoreCase("country")) {
                    demoflag = false;
                }
                break;
            default:
                break;
            }

            eventType = xpp.next();
        }

    }