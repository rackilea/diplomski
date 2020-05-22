@Test
public void testGoHome() {
    // Setup
    Controller controller = ...
    Map<String, Bar> model = new HashMap<String, Bar>();

    // Test
    assertEquals("foobar.jsp", controller.goHome(model));
    assertNotNull(model.get("bar"));
}