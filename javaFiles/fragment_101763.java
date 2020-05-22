try {
    shouldThrow()
    fail("Expected exception");
} catch(XMLClientNotFound e) {
    assertThat(e).hasMessage("Expected message");  //FEST-Assert syntax
}