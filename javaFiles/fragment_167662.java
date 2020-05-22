@Override
public PrintWriter getWriter() throws IOException
{
    if (_outputType == OutputType.STREAM)
        throw new IllegalStateException("STREAM");

    if (_outputType == OutputType.NONE)
    {
        /* get encoding from Content-Type header */
        String encoding = _characterEncoding;
        if (encoding == null)
        {
            encoding = MimeTypes.inferCharsetFromContentType(_contentType);
            if (encoding == null)
                encoding = StringUtil.__ISO_8859_1;
            setCharacterEncoding(encoding);
        }