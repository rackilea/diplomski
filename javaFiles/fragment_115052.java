@Test
public void testAUnmarshaller() throws IOException {
    // given
   ObjectMapper objectMapper = new ObjectMapper();
    PapiSite payload = objectMapper.readValue(RESPONSE_JSON, A.class); 

    // then
    assertNotNull(payload);
    assertTrue(payload.isEnabled());
    assertEquals("XXX", payload.getName());
}