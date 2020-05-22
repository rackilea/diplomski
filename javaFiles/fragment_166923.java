@Test
public void testWithRealization() {
Field field = candidateMenuController.getClass().getDeclaredField("eventService");
field.set(candidateMenuController, new EventServiceImpl());

// Test Code
}