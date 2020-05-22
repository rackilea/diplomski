public static StreamEncoder forOutputStreamWriter(OutputStream out,
        Object lock,
        String charsetName)
        throws UnsupportedEncodingException
{
    String csn = charsetName;
    if (csn == null)
        csn = Converters.getDefaultEncodingName();
    if (!Converters.isCached(Converters.CHAR_TO_BYTE, csn)) {
        try {
            if (Charset.isSupported(csn))
                return new CharsetSE(out, lock, Charset.forName(csn));
        } catch (IllegalCharsetNameException x) { }
    }
    return new ConverterSE(out, lock, csn);
}