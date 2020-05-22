public static boolean isValidUTF8( byte[] input ) {

    CharsetDecoder cs = Charset.forName("UTF-8").newDecoder();

    try {
        cs.decode(ByteBuffer.wrap(input));
        return true;
    }
    catch(CharacterCodingException e){
        return false;
    }       
}