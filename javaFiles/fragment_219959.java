final Charset charset = Charset.forName("UTF-8");
    final CharsetDecoder decoder = charset.newDecoder();
    decoder.onMalformedInput(CodingErrorAction.REPORT);

    try {
        final String s = decoder.decode(ByteBuffer.wrap(bytes)).toString();
        Log.d( s );
    } catch( CharacterCodingException e ) {
        // don't log binary data
    }