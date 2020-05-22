public static List<Term> readConfig(XmlPullParser parser)
        throws XmlPullParserException, IOException
{

    List<Term> terms = new ArrayList<Term>();

    parser.require(XmlPullParser.START_TAG, ns, APP);

    int eventType = parser.getEventType();
    while (eventType != XmlPullParser.END_DOCUMENT)
    {
        String tagName = parser.getName();

        if (eventType == XmlPullParser.START_TAG && tagName.equals(APP))
        {
            // Attrubites
            String name = parser.getAttributeValue(null, "name");
            Logger.log(name);
        }
        else if (tagName != null && tagName.equals(TERM))
        {
            terms.add(readTerm(parser));
        }
        else if (eventType == XmlPullParser.END_TAG && tagName.equals(APP))
        {
            break;
        }
        eventType = parser.next();

    }

    return terms;
}