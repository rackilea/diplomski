public static ArrayList<HModel> model_parse(InputStream url) throws IOException, XmlPullParserException {
    final ArrayList<HModel> results = new ArrayList<HModel>(1000);

    XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
    factory.setNamespaceAware(true);
    XmlPullParser xpp = factory.newPullParser();

    xpp.setInput(url, "UTF-8");

    xpp.nextTag();
    xpp.require(XmlPullParser.START_TAG, null, "NewDataSet");
    while (xpp.nextTag() == XmlPullParser.START_TAG) {
        xpp.require(XmlPullParser.START_TAG, null, "Hispania_DB");
        HModel mdl = new HModel();
        xpp.nextTag();
        xpp.require(XmlPullParser.START_TAG, null, "Model");
        mdl.model = xpp.nextText();
        xpp.require(XmlPullParser.END_TAG, null, "Model");

        xpp.nextTag();
        xpp.require(XmlPullParser.START_TAG, null, "Capacity");
        mdl.capacity = Double.parseDouble(xpp.nextText());
        xpp.require(XmlPullParser.END_TAG, null, "Capacity");

        xpp.nextTag();
        xpp.require(XmlPullParser.START_TAG, null, "Surface");
        mdl.surface = Double.parseDouble(xpp.nextText());
        xpp.require(XmlPullParser.END_TAG, null, "Surface");

        xpp.nextTag();
        xpp.require(XmlPullParser.START_TAG, null, "Air_x0020_Flow");
        mdl.airflow = xpp.nextText();
        xpp.require(XmlPullParser.END_TAG, null, "Air_x0020_Flow");

        xpp.nextTag();
        xpp.require(XmlPullParser.START_TAG, null, "Air_x0020_Throw");
        mdl.airthrow = xpp.nextText();
        xpp.require(XmlPullParser.END_TAG, null, "Air_x0020_Throw");

        xpp.nextTag();
        xpp.require(XmlPullParser.START_TAG, null, "Number_Fans");
        mdl.nm_fans = xpp.nextText();
        xpp.require(XmlPullParser.END_TAG, null, "Number_Fans");

        xpp.nextTag();
        xpp.require(XmlPullParser.START_TAG, null, "Fan_Diameter");
        mdl.fandiam = xpp.nextText();
        xpp.require(XmlPullParser.END_TAG, null, "Fan_Diameter");

        xpp.nextTag();
        xpp.require(XmlPullParser.START_TAG, null, "L");
        mdl.l = xpp.nextText();
        xpp.require(XmlPullParser.END_TAG, null, "L");

        xpp.nextTag();
        xpp.require(XmlPullParser.START_TAG, null, "H");
        mdl.h = xpp.nextText();
        xpp.require(XmlPullParser.END_TAG, null, "H");

        xpp.nextTag();
        xpp.require(XmlPullParser.START_TAG, null, "W");
        mdl.w = xpp.nextText();
        xpp.require(XmlPullParser.END_TAG, null, "W");

        xpp.nextTag();
        xpp.require(XmlPullParser.START_TAG, null, "Weight");
        mdl.weight = xpp.nextText();
        xpp.require(XmlPullParser.END_TAG, null, "Weight");

        xpp.nextTag();
        xpp.require(XmlPullParser.START_TAG, null, "Inlet");
        mdl.inlet = xpp.nextText();
        xpp.require(XmlPullParser.END_TAG, null, "Inlet");

        xpp.nextTag();
        xpp.require(XmlPullParser.START_TAG, null, "Outlet");
        mdl.outlet = xpp.nextText();
        xpp.require(XmlPullParser.END_TAG, null, "Outlet");

        xpp.nextTag();
        xpp.require(XmlPullParser.START_TAG, null, "Fan_x0020_Voltage");
        mdl.fan_volt = xpp.nextText();
        xpp.require(XmlPullParser.END_TAG, null, "Fan_x0020_Voltage");

        xpp.nextTag();
        xpp.require(XmlPullParser.START_TAG, null, "Fan_x0020_Current");
        mdl.fan_curr = xpp.nextText();
        xpp.require(XmlPullParser.END_TAG, null, "Fan_x0020_Current");

        xpp.nextTag();
        xpp.require(XmlPullParser.START_TAG, null, "Total_x0020_Defrost");
        mdl.defr = xpp.nextText();
        xpp.require(XmlPullParser.END_TAG, null, "Total_x0020_Defrost");

        xpp.nextTag();
        xpp.require(XmlPullParser.END_TAG, null, "Hispania_DB");

        results.add(mdl);
    }
    xpp.require(XmlPullParser.END_TAG, null, "NewDataSet");

    return results;
}