@Test
public void testGrabString() throws Exception {
    String expected = "test input from console";
    ByteArrayInputStream fakeIS = new ByteArrayInputStream(expected.getBytes());
    MyStreamReader myStreamReader = new MyStreamReader(fakeIS);

    String actual = myStreamReader.grabString();
    assertEquals(expected, actual);
}