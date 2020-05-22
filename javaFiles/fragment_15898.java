public void parseMQL(String query) {
    iParser parser = buildMQLParser(query);
    CommonTree commonTree = null;
    try {
        commonTree = (CommonTree) parser.query().getTree();
    } catch (MismatchedTokenException e){
        //not production-quality code, just forming a useful message
        String expected = e.expecting == -1 ? "<EOF>" : iParser.tokenNames[e.expecting];
        String found = e.getUnexpectedType() == -1 ? "<EOF>" : iParser.tokenNames[e.getUnexpectedType()];

        System.out.println("Fatal mismatched token exception: expected " + expected + " but was " + found);   

    } catch (RecognitionException e) {
        System.out.println("Fatal recognition exception " + e.getClass().getName()
                + " : " + e);

    } catch (Exception e) {
        System.out.println("Other exception : " + e.getMessage());
    }
}