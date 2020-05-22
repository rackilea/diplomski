private ArrayList<Contact> parse() throws XmlPullParserException,IOException
{
    XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
    factory.setNamespaceAware(true);
    XmlPullParser parser = factory.newPullParser();

    AssetManager assetManager = getAssets();
    parser.setInput(getAssets().open("myxml.xml"),null);

    ArrayList<Contact> Contacts = null;
    int eventType = parser.getEventType();
    Contact con = null;

    while (eventType != XmlPullParser.END_DOCUMENT){
        String name;
        switch (eventType){
            case XmlPullParser.START_DOCUMENT:
                Contacts = new ArrayList();
                break;
            case XmlPullParser.START_TAG:
                name = parser.getName();
                if (name.equals("record"))
                    con = new Contact();
                else if (con != null){
                    if (name.equals("name"))
                        con.name = parser.nextText();
                    else if (name.equals("email"))
                        con.email= parser.nextText();
                }
                break;
            case XmlPullParser.END_TAG:
                name = parser.getName();
                if (name.equalsIgnoreCase("record") && con != null)
                    Contacts.add(con);
        }
        eventType = parser.next();
    }

    return Contacts;

}`