catch(CharConversionException ex) {
    handle(ex);
}
catch(SAXException ex) {
    if(ex.getCause() instanceof CharConversionException) {
        handle((CharConversionException)ex.getCause());
    }
}

…

static void handle(CharConversionException ex) {
    // just an example
    System.out.println("malformed bytes or wrong encoding: "+ex.getMessage());
}