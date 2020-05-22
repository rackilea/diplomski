HttpEntity entity = response.getEntity();
if (entity != null) {
    InputStream instream = entity.getContent();
    try {

        //read stream 
        //if expect binary data:
        BufferedInputStream stream = new BufferedInputStream(instream);
        int maxBytes = 128 * 1024;
        if(entity.getContentLength() > maxBytes) {
            throw new IllegalArgumentException("Much too big!");
        }
        byte[] bytes = new byte[(int) entity.getContentLength()];
        int offset = 0, count = bytes.length;
        while(stream.read(bytes, offset, count) > -1 && count > 0) {
            count -= offset;
        }

        final Bitmap responseImage = BitmapFactory.decodeByteArray(
                bytes, 0, bytes.length);

        //or if you expect text
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(instream, Charset.forName(
                        entity.getContentEncoding().getValue())));

        StringBuffer buffer = new StringBuffer();
        String line;
        while((line = reader.readLine()) != null) {
            buffer.append(line);
        }

        final String responseText = buffer.toString();

    } finally {
        instream.close();
    }
}