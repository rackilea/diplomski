try
    {
        URL url = new URL("http://en.wikipedia.org/wiki/Mexico");
        Matcher m = patt.matcher(getURLContent(url));
        while (m.find()) {
           String stateURL = m.group(1);
           String stateName = m.group(2);
           System.out.println(stateName + "," + stateURL);
        }
    }
    ...