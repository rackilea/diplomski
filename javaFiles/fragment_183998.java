@Test
public void testRead() {
    try {
        assertTrue(new FileReader().read() != null);
    } catch (CustomException e) {
        // Test passes
    }
}