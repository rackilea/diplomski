public static HttpServletRequest getRequest() {
    return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
}

/**
 * Returns the host name from the current request.
 *
 * @return
 */
public static String getRequestHost() {
    HttpServletRequest request = getRequest();
    if (request == null) {
        return null;
    }
    String result = request.getHeader("x-forwarded-host");
    if (result == null || result.isEmpty()) {
        result = request.getHeader("host");
    }
    return result;
}


/*
 * (non-Javadoc)
 * 
 * @see com.sun.facelets.FaceletFactory#getFacelet(java.lang.String)
 */
public Facelet getFacelet(String uri) throws IOException, FaceletException,
        FacesException, ELException {
    String key = getRequestHost() + ":" + uri;
    URL url = (URL) this.relativeLocations.get(key);
    if (url == null) {
        url = this.resolveURL(this.baseUrl, uri);
        if (url != null) {
            Map newLoc = new HashMap(this.relativeLocations);
            newLoc.put(key, url);
            this.relativeLocations = newLoc;
        } else {
            throw new IOException("'" + uri + "' not found.");
        }
    }
    return this.getFacelet(url);
}