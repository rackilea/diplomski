@Test
void testLaunch() {
    PrintStream original = System.out;
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream tps = new PrintStream(baos);
    Bird myBird = new Bird("Macaw");
    System.setOut(tps);
    myBird.launch();
    System.setOut(original);
    tps.flush();
    assertEquals("Flapping the wings to take-off", baos.toString());
}