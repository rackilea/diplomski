private static class UAC extends NaiveUserAgent {
    @Override
    public String resolveURI(String uri) {
        return uri;
    }

    @Override
    protected InputStream resolveAndOpenStream(String uri) {
        java.io.InputStream is = null;
        URL url = UAC.class.getResource(uri);
        if (url == null) {
            XRLog.load("Didn't find resource [" + uri + "].");
            return null;
        }
        try {
            is = url.openStream();
        }
        catch (java.net.MalformedURLException e) {
            XRLog.exception("bad URL given: " + uri, e);
        }
        catch (java.io.FileNotFoundException e) {
            XRLog.exception("item at URI " + uri + " not found");
        }
        catch (java.io.IOException e) {
            XRLog.exception("IO problem for " + uri, e);
        }
        return is;
    }
}

XHTMLPanel panel = new XHTMLPanel(new UAC());