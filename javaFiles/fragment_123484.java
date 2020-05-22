public static StreamEncoder forOutputStreamWriter(OutputStream out,
        Object lock,
        String charsetName)
        throws UnsupportedEncodingException
{
    String csn = charsetName;
    if (csn == null)
        csn = Charset.defaultCharset().name();
    try {
        if (Charset.isSupported(csn))
            return new StreamEncoder(out, lock, Charset.forName(csn));
    } catch (IllegalCharsetNameException x) { }
    throw new UnsupportedEncodingException (csn);
}