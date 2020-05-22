private static byte[] convert(final InputStream is) throws IOException {
    final byte[] END_SIG = new byte[]{"\r".getBytes()[0], "\n".getBytes()[0]};
    final List<Byte> streamBytes = new ArrayList<Byte>();
    int readByte;
    byte[] bytes;

    // Read HTTP header:
    while ((readByte = is.read()) != -1) {
        streamBytes.add((byte) readByte);
        if (streamBytes.size() > 4) {
            int sbsize = streamBytes.size();

            int rp = sbsize - 4;
            int np = sbsize - 2;
            int rn = sbsize - 3;
            int nn = sbsize - 1;

            if (END_SIG[0] == streamBytes.get(rp) && END_SIG[0] == streamBytes.get(np) && END_SIG[1] == streamBytes.get(rn) && END_SIG[1] == streamBytes.get(nn)) {
                break;
            }
        }
    }

    // Convert to byte[]
    bytes = new byte[streamBytes.size()];
    for (int i = 0, iMAX = bytes.length; i < iMAX; ++i) {
        bytes[i] = streamBytes.get(i);
    }

    // drop header
    streamBytes.clear();

    // Convert byte[] to String & retrieve the content-length:
    final String HEADER = new String(bytes);
    int startIndex = HEADER.indexOf("Content-Length:") + "Content-Length:".length() + 1;
    int length = 0;
    int I = startIndex;
    while (Character.isDigit(HEADER.charAt(I++))) {
        ++length;
    }
    final String CL = HEADER.substring(startIndex, startIndex + length);

    // Determine the number of bytes to read from now on:
    int ContentLength = Integer.parseInt(CL);
    while (streamBytes.size() < ContentLength) {
        byte[] buffer = new byte[256];

        int rc = is.read(buffer);
        for (int irc = 0; irc < rc; ++irc) {
            streamBytes.add(buffer[irc]);
        }
    }

    // Convert to byte[]
    bytes = new byte[streamBytes.size()];
    for (int i = 0, iMAX = bytes.length; i < iMAX; ++i) {
        bytes[i] = streamBytes.get(i);
    }

    return bytes;
}