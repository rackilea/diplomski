public void testNullParameter() {
    try {
        IPAddress addr = new IPAddress(null);
        fail("InvalidIPAddressException not thrown.");
    } catch(InvalidIPAddressException e) {
        assertNotNull(e.getMessage());
    }
}