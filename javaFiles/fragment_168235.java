private static final Map<Char, String> myDecodeLookup = new Hashmap<Char,String>();

static{ //initializer block
    myDecodeLookup.put('A', "2");
    myDecodeLookup.put('B', "2");
    //and so and and so forth
}

private String decode(char c) throws KeyNotFoundException{
   return MyClassName.myDecodeLookup.get(c); //you should code this to support the keynotfoundexception that this might throw, or not.
}