@Test 
public void appRunShouldWaitForInput(){
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // As you have already noted, you would need to kick this off on another thread and use a blocking implementation of InputStream to test what you want to test.
    new App(new ByteArrayInputStream(), output).start();

    assertThat(output.toByteArray().length, is(0));
}