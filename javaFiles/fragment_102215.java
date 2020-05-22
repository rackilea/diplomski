@Test
public void test1() {
    Integer hexInt = Integer.parseInt("FF0000", 16);
    Color createdColor = new Color(hexInt);
    assertEquals(Color.RED, createdColor);
}