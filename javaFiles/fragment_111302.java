try {
    LogicalDocumentImpl testLogicalDoc = new LogicalDocumentImpl(-4);  
    fail("should throw");
}
    catch (AssertionError e) {
}