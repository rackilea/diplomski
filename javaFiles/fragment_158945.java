private final static URL DEFAULT_URL = getDefaultUrl();

private static URL getDefaultUrl() {
    try {
        return new URL("http://www.yadayada.com?wsdl"); 
    } catch (Exception e) {
        //what do you want to do here?
        return null; //that is an option
        throw new AssertionError("Invalid URL"); //that is another one
    }
}