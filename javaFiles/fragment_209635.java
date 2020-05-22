try {
    assertEquals("Legal Values: Package Type must be P or R", Shipping.shippingCost('P', -5));
    Assert.fail( "Should have thrown an exception" );
} 
catch (Exception e) {
    String expectedMessage = "this is the message I expect to get";
    Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
}