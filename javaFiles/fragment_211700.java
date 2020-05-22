String webServiceURL="web service url or document url here";
        URL geoLocationDetailXMLURL = new URL(webServiceURL);
        URLConnection geoLocationDetailXMLURLConnection = geoLocationDetailXMLURL.openConnection();
        geoLocationDetailXMLURLConnection.setConnectTimeout(120000);
        geoLocationDetailXMLURLConnection.setReadTimeout(120000);
        BufferedReader geoLeocationDetails = new BufferedReader(new InputStreamReader(geoLocationDetailXMLURLConnection.getInputStream(), "UTF-8"));
        InputSource inputSource = new InputSource(geoLeocationDetails);
        saxParser.parse(inputSource, handler);