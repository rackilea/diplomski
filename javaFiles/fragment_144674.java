try {

        XmlPullParser xpp = getResources().getXml(R.xml.bookmarks);

        while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) {
            if (xpp.getEventType() == XmlPullParser.START_TAG) {
                if (xpp.getName().equals("Bookmark")) {

                    Log.e("MY_VALUE", " * " + xpp.getAttributeValue(0) + " * ");
                    Log.e("MY_VALUE", " * " + xpp.getAttributeValue(1) + " * ");
                    Log.e("MY_VALUE", " * " + xpp.getAttributeValue(5) + " * ");
                    Log.e("MY_VALUE", " * " + xpp.getAttributeValue(2) + " * ");
                    Log.e("MY_VALUE", " * " + xpp.getAttributeValue(3) + " * ");
                    Log.e("MY_VALUE", " * " + xpp.getAttributeValue(4) + " * ");

                    Bookmark bookmark = new Bookmark();
                    bookmark.setName(xpp.getAttributeValue(0));
                    bookmark.setIcon(xpp.getAttributeValue(1));
                    bookmark.setId(xpp.getAttributeValue(2));
                    bookmark.setSearchUrl(xpp.getAttributeValue(3));
                    bookmark.setNativeUrl(xpp.getAttributeValue(4));
                    arrayList.add(bookmark);

                }
            }

            xpp.next();
        }
    } catch (XmlPullParserException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }