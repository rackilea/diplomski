/* get the specs for a given url out of the cache, and compute and
 * cache them if they're not there.
 */
private void parseSpecs(URL url) throws MalformedURLException {
    String spec = url.getFile();

    int separator = spec.indexOf("!/");
    /*
     * REMIND: we don't handle nested JAR URLs
     */
    if (separator == -1) {
        throw new MalformedURLException("no !/ found in url spec:" + spec);
    }

    jarFileURL = new URL(spec.substring(0, separator++));
    entryName = null;

    /* if ! is the last letter of the innerURL, entryName is null */
    if (++separator != spec.length()) {
        entryName = spec.substring(separator, spec.length());
        entryName = ParseUtil.decode (entryName);
    }
}