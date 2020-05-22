private Document parseXmlFile(){
    DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();

    try {
       DocumentBuilder db = dbf.newDocumentBuilder();
       Resources res = getResources();
       InputStream in = res.openRawResource(R.raw.options);
       dom=db.parse(in); //Here instead of passing the URI string, you pass the input stream of the file.

    }

    catch(ParserConfigurationException pce){
        pce.printStackTrace();
    }
    catch(SAXException se){
        se.printStackTrace();
    }
    catch(IOException ioe){
        ioe.printStackTrace();
    }
    return dom;

}