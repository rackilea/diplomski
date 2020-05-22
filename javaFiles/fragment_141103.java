@Test
  public void testCanonical() throws IOException {
    test("d:tarGet\\..\\Target", "File exist and drive letter is on the current one");
    test("d:tarGet\\..\\Target\\.\\..\\", "File exist and drive letter is on the current one, but parent of current drive should exist");
    test("d:tarGet\\non-existent\\..\\..\\Target\\.\\..\\", "Relative path contains non-existent file");
    test("d:target\\\\file", "Double slash");
    test("c:tarGet\\..\\Target\\.", "File doesn't exist and drive letter is on different drive than the current one");
    test("l:tarGet\\..\\Target\\.\\..\\", "Drive letter doesn't exist");
    test("za:tarGet\\..\\Target\\.\\..\\", "Drive letter is double so not valid");
    test("d:tarGet|Suffix", "Path contains invalid chars in windows (|)");
    test("d:tarGet\u0000Suffix", "Path contains invalid chars in both linux and windows (\\0)");
  }

  private void test(String filename, String message) throws IOException {
    java.io.File file = new java.io.File(filename);
    System.out.println("Use:  " + filename + " -> " + message);
    System.out.println("F-GET:     " + Try.of(() -> file.getPath()));
    System.out.println("F-ABS:     " + Try.of(() -> file.getAbsolutePath()));
    System.out.println("F-CAN:     " + Try.of(() -> file.getCanonicalPath()));
    System.out.println("P-TO:      " + Try.of(() -> file.toPath()));
    System.out.println("P-ABS:     " + Try.of(() -> file.toPath().toAbsolutePath()));
    System.out.println("P-NOR:     " + Try.of(() -> file.toPath().normalize()));
    System.out.println("P-NOR-ABS: " + Try.of(() -> file.toPath().normalize().toAbsolutePath()));
    System.out.println("P-ABS-NOR: " + Try.of(() -> file.toPath().toAbsolutePath().normalize()));
    System.out.println("P-REAL:    " + Try.of(() -> file.toPath().toRealPath()));
    System.out.println("");
  }