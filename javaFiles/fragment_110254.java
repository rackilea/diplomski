catch(CharConversionException ex) {
    System.out.println("malformed bytes or wrong encoding: "+ex.getMessage());
}
catch(SAXException ex) {
    if(ex.getCause() instanceof CharConversionException) {
        System.out.println("malformed bytes or wrong encoding: "+ex.getMessage());
    }
}