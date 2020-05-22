public static void main(String[] args) {
    if (args.length == 0 || args[0] == null || (args[0] = args[0].trim()).isEmpty()) {
        System.out.println("No argument passed or argument empty!");
        return;
    }

    String arg = args[0];
    System.out.println("arg: " + arg + ", arg len: " + arg.length());

    BitSet bs = new BitSet(arg.length());
    for (int i = 0; i < arg.length(); i++) {
        if (arg.charAt(i) == '1') {
            bs.set(i, true); 
        }
    }
    ByteBuffer bb = ByteBuffer.wrap(bs.toByteArray());
    Charset cs = Charset.forName("UTF-8");
    CharsetDecoder csd =
            cs.newDecoder().onMalformedInput(CodingErrorAction.REPORT).
            onUnmappableCharacter(CodingErrorAction.REPORT)
            ;

    try {
        CharBuffer cb = csd.decode(bb);
        String uns = cb.toString();
        System.out.println("Got unicode string of len " + uns.length() + ": " + uns + " from " + arg + " -- no errors!");
    } catch (CharacterCodingException cce) {
        System.out.println("Invalid UTF-8 unicode string! " + cce.getMessage());
    }
}