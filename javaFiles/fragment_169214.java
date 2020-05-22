private static BitSet badUriChars = new BitSet(256);
static {
    badUriChars.set(0, 255, true);
    badUriChars.andNot(org.apache.commons.httpclient.URI.unwise);
    badUriChars.andNot(org.apache.commons.httpclient.URI.space);
    badUriChars.andNot(org.apache.commons.httpclient.URI.control);
    badUriChars.set('<', false);
    badUriChars.set('>', false);
    badUriChars.set('"', false);
}

public static URI toURIorFail(String url) throws URISyntaxException {
    URI uri = URIUtil.encode(url, badUriChars, "UTF-8");
    return new URI(uri);
}