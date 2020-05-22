public static void main(String[] args) {
    String value = "á, é, í, ó, ú, ü, ñ, ¿";
    String retValue = "";
    String convertValue2 = "";
    ByteBuffer convertedBytes = null;
    try {
        CharsetEncoder encoder2 = Charset.forName("Windows-1252").newEncoder();
        CharsetEncoder encoder3 = Charset.forName("UTF-8").newEncoder();             
        System.out.println("value = " + value);

        assert encoder2.canEncode(value);
        assert encoder3.canEncode(value);

        ByteBuffer conv1Bytes = encoder2.encode(CharBuffer.wrap(value.toCharArray()));

        retValue = new String(conv1Bytes.array(), Charset.forName("Windows-1252"));

        System.out.println("retValue = " + retValue);

        convertedBytes = encoder3.encode(CharBuffer.wrap(retValue.toCharArray()));
        convertValue2 = new String(convertedBytes.array(), Charset.forName("UTF-8"));
        System.out.println("convertedValue =" + convertValue2);
    } catch (Exception e) {
        e.printStackTrace();
    }
}