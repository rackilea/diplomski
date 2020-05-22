@Test
public void out() {
    System.out.print("hello");
    assertEquals("hello", outContent.toString());
}

@Test
public void err() {
    System.err.print("hello again");
    assertEquals("hello again", errContent.toString());
}