public volatile boolean parsingComplete = true;

public void parseXMLAndStoreIt(XmlPullParser myParser) {
    int event;
    String text = null;
    try {
        event = myParser.getEventType();
        while (event != XmlPullParser.END_DOCUMENT) {
            String name = myParser.getName();

            switch (event) {
                case XmlPullParser.START_TAG:
                    break;

                case XmlPullParser.TEXT:
                    text = myParser.getText();
                    break;
                case XmlPullParser.END_TAG:
                    if (name.equals("UploadImageResult")) {
                        uploadedImage = text;
                        uploadedImage = uploadedImage.replace("\"", "");
                    }
                    break;
            }
            event = myParser.next();
        }
        parsingComplete = false;
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static String createSoapHeader() {
    String soapHeader;

    soapHeader = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
            + "<soap:Envelope "
            + "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\""
            + " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""
            + " xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"" + ">";
    return soapHeader;
}

public static byte[] getReqData(String data) {
    StringBuilder requestData = new StringBuilder();

    requestData.append(createSoapHeader());
    requestData.append("<soap:Body>" + "<UploadImage" + " xmlns=\"http://example.org/\">" + "<ImageContent>").append(data).append("</ImageContent>\n").append("<imageExtenstion>jpg</imageExtenstion>").append("</UploadImage> </soap:Body> </soap:Envelope>");
    Log.d("reqData: ", requestData.toString());
    return requestData.toString().trim().getBytes();
}

private static String convertStreamToString(InputStream is)
        throws UnsupportedEncodingException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(is,
            "UTF-8"));
    StringBuilder sb = new StringBuilder();
    String line;
    try {
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return sb.toString();

}