static <T extends Number> T sloppyParseNumber(String str,Class<T> clas) {

    if (clas == null) throw new NullPointerException("clas is null");

    try {

        if(clas.equals(Integer.class)) {
            return (T) Integer.valueOf(str);
        }
        else if(clas.equals(Double.class)) {
            return (T) Double.valueOf(str);
        }
        //so on

    catch(NumberFormatException|NullPointerException ex) {
        // force call with valid arguments
        return sloppyParseNumber("0", clas);
    }

    throw new IllegalArgumentException("Invalid clas " + clas);

}