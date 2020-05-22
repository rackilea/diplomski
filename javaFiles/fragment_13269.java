public static final String getValid(File f) throws IOException {
    FileInputStream fis = new FileInputStream(f);
    byte[] buff = new byte[12];
    int bytes = 0, pos = 0;

    while (pos < buff.length && (bytes = fis.read(buff, pos, buff.length - pos)) > 0) {
        pos += bytes;
    }

    fis.close();

   // this is your test.... which should bitmask the value too:
    if ((buff[0] & 0x000000ff) == 255) {
        return "MP3 " + f;
    }
    // My testing indicates this is the MP3 magic number
    if (   'I' == (char)buff[0]
        && 'D' == (char)buff[1]
        && '3' == (char)buff[2]) {
        return "MP3 ID3 Magic" + f;
    }
    // This is the magic number from wikipedia (spells '1,!')
    if (49 == buff[0] && 44 == buff[1] && 33 == buff[2]) {
        return "MP3 ID3v2" + f;
    }
    if (   'W' == (char)buff[8]
        && 'A' == (char)buff[9]
        && 'V' == (char)buff[10]
        && 'E' == (char)buff[11]) {
        return "WAVE " + f;
    }

    return "unknown " + f;

}