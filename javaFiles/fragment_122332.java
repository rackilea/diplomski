private InputStream openStream(final URL url) throws IOException
{
    final URLConnection cxn = url.openConnection();
    final String contentEncoding = cxn.getContentEncoding();
    if(contentEncoding == null)
        return cxn.getInputStream();
    else if(contentEncoding.equalsIgnoreCase("gzip")
               || contentEncoding.equalsIgnoreCase("x-gzip"))
        return new GZIPInputStream(cxn.getInputStream());
    else
        throw new IOException("Unexpected content-encoding: " + contentEncoding);
}