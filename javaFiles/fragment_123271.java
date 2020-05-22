/**
 * Write the xml report to the file.
 *
 * NB: Transforms it into html on the fly.
 *
 * @param file Where to put it.
 * @param xml - What to put in it.
 */
protected void writeReport(File file, StringBuilder xml) {
    try {
        // Transform it through the xsl.
        Source xslt = new StreamSource(this.getClass().getResourceAsStream("SavedReport.xsl"));
        // Build a transformer.
        Transformer transformer = factory.newTransformer(xslt);
        // Make URIs resolve to the same location as the xsl.
        transformer.setURIResolver(justTheNameMeansLocal);
        // Make a string stream out of the xml.
        Source source = new StreamSource(new ByteArrayInputStream(xml.toString().getBytes("UTF-8")));
        // Transform it straight into the output file.
        try (FileOutputStream stream = new FileOutputStream(file)) {
            StreamResult result = new StreamResult(stream);
            transformer.transform(source, result);
        }
    } catch (UnsupportedEncodingException ex) {
        Logger.writeLog(ME + "writeReport", ex, Logger.LOG_ERROR);
    } catch (TransformerException ex) {
        Logger.writeLog(ME + "writeReport", ex, Logger.LOG_ERROR);
    } catch (FileNotFoundException ex) {
        Logger.writeLog(ME + "writeReport", ex, Logger.LOG_ERROR);
    } catch (IOException ex) {
        Logger.writeLog(ME + "writeReport", ex, Logger.LOG_ERROR);
    }
}

/**
 * Resolve URI that are just a name to local.
 */
static class JustTheNameMeansLocal implements URIResolver {

    public Source resolve(String href, String base) throws TransformerException {
        // Name only - resolve to local - otherwise hand off the resolution to default.
        return href.contains("\\") ? null : new StreamSource(SavedHTMLReport.class.getResourceAsStream(href));
    }

}
private static final URIResolver justTheNameMeansLocal = new JustTheNameMeansLocal();
// Transformer factory.
protected static final TransformerFactory factory = TransformerFactory.newInstance();