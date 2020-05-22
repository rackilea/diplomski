public String cutStringForTEXT(String string) {
    String ENCODING = "ISO-8859-1";
    int FIELD_SIZE = 65535;
    try {
        byte[] bytes = string.getBytes(ENCODING);
        if (bytes.length >= FIELD_SIZE) {
            return new String(Arrays.copyOfRange(bytes, 0, FIELD_SIZE), ENCODING);
        }
    } catch (UnsupportedEncodingException ex) {
    }
    return string;
}