public boolean isMain;

public int i;

public String tmpVal;

private Vector<WifiDescription> mWifiDescription;
private WifiDescription currentWifi;

/**
 * @return
 */
public Vector<WifiDescription> getWifiDescription() {
    Log.v("test parsage getWifiDescription","");
    return mWifiDescription;
}

@Override
public void startDocument() throws SAXException {
    // create new object
    i=0;
    Log.v("test parsage Start","");
    this.mWifiDescription = new Vector<WifiDescription>();
}


@Override
public void endDocument() throws SAXException {
    // nothing we need to do here
    Log.v("test parsage End","");
}

@Override
public void startElement(String namespaceURI, String localName, String qName, Attributes atts)
        throws SAXException {
    Log.v("test parsage StartElement","");
    if(localName.equals("main")) {
        isMain=true;
        Log.v("test parsage main","");
    }

    if(localName.equals("wifi") && isMain ) {
        this.currentWifi = new WifiDescription();

        tmpVal = atts.getValue(WifiDescription.MSSID);
        this.currentWifi.mBSSID=tmpVal;

        tmpVal = atts.getValue(WifiDescription.LATITUDE);
        this.currentWifi.mLatitude=tmpVal;

        tmpVal = atts.getValue(WifiDescription.LONGITUDE);
        this.currentWifi.mLongitude=tmpVal;

        tmpVal = atts.getValue(WifiDescription.SSID);
        this.currentWifi.mSSID=tmpVal;
        isWifi=true;
    }
}

@Override
public void endElement(String namespaceURI, String localName, String qName) throws SAXException {

    Log.v("test parsage EndElement","");
    if(localName.equals("wifi")) {
        //System.out.println("passe dans End landmark");
        isWifi=false;
        i++;
        this.mWifiDescription.add(currentWifi);
    }
    Log.v("XML", "DONE \n");
}