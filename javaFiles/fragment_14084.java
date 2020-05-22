@Test
public void testProcessDestinationByStAX() throws Exception {
    // setup
    logger.info("Testing processDestinationByStAX");
    DestinationProcessor destinationProcessor = new DestinationProcessor();
    int expResult = numOfDestinations;
    logger.info("parsing  " + destinationFileName);

    // test
    List<Destination> result = destinationProcessor.processDestinationByStAX(destinationFileName);

    // verify
    logger.info("Successfully Parsed  : " + result.size() + " destinations ...");
    assertEquals(expResult, result.size());
}