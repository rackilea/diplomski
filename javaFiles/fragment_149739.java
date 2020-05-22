public static boolean isUTF8MisInterpreted( String input ) {
          //convenience overload for the most common UTF-8 misinterpretation
          //which is also the case in your question
      return isUTF8MisInterpreted( input, "Windows-1252");  
}

public static boolean isUTF8MisInterpreted( String input, String encoding) {

    CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
    CharsetEncoder encoder = Charset.forName(encoding).newEncoder();
    ByteBuffer tmp;
    try {
        tmp = encoder.encode(CharBuffer.wrap(input));
    }

    catch(CharacterCodingException e) {
        return false;
    }

    try {
        decoder.decode(tmp);
        return true;
    }
    catch(CharacterCodingException e){
        return false;
    }       
}

public static void main(String args[]) {
    String test = "guide (but, yeah, itâ€™s okay to share it with â€˜em).";
    String test2 = "guide (but, yeah, it’s okay to share it with ‘em).";
    System.out.println( isUTF8MisInterpreted(test)); //true
    System.out.println( isUTF8MisInterpreted(test2)); //false

}