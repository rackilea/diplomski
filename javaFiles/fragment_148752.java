public static String snapFromHtmlWithCookies(Context context, String xPath, String attrToSnap, String urlString,
                    String cookies) throws IOException, XPatherException {
            String snap = "";

            // create an instance of HtmlCleaner
            HtmlCleaner cleaner = new HtmlCleaner();

            // take default cleaner properties
            CleanerProperties props = cleaner.getProperties();

            props.setAllowHtmlInsideAttributes(true);
            props.setAllowMultiWordAttributes(true);
            props.setRecognizeUnicodeChars(true);
            props.setOmitComments(true);

            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);

            // optional cookies
            connection.setRequestProperty(context.getString(R.string.cookie_prefix), cookies);
            connection.connect();

            // use the cleaner to "clean" the HTML and return it as a TagNode object
            TagNode root = cleaner.clean(new InputStreamReader(connection.getInputStream()));

            Object[] foundNodes = root.evaluateXPath(xPath);

            if (foundNodes.length > 0) {
                    TagNode foundNode = (TagNode) foundNodes[0];
                    snap = foundNode.getAttributeByName(attrToSnap);
            }

            return snap;
    }