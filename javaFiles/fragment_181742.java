public void returnTableParseXml(){
    try {
        wifis = WifiParser.parse(getAssets().open("wifi.xml"));
    }
    catch (IOException e) 
    {
        Log.d("XML Main","onCreate(): parse() failed");
        return;
    }
}