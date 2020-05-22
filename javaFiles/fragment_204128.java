@Test
  public void testSplice() {
    final String[] array = new String[] {"a", "b", "c", "d", "e", "f"};

    Assert.assertArrayEquals(new String[] {"c", "d", "e", "f"}, Arrays.splice(array, 0, 2));
    Assert.assertArrayEquals(new String[] {"a", "d", "e", "f"}, Arrays.splice(array, 1, 2));
    Assert.assertArrayEquals(new String[] {"a", "b", "e", "f"}, Arrays.splice(array, 2, 2));
    Assert.assertArrayEquals(new String[] {"a", "b", "c", "f"}, Arrays.splice(array, 3, 2));
    Assert.assertArrayEquals(new String[] {"a", "b", "c", "d"}, Arrays.splice(array, 4, 2));
    try {
      Arrays.splice(array, 5, 2);
      Assert.fail("Expected ArrayIndexOutOfBoundsException");
    }
    catch (final ArrayIndexOutOfBoundsException e) {
    }

    try {
      Arrays.splice(array, -2, 3);
      Assert.fail("Expected ArrayIndexOutOfBoundsException");
    }
    catch (final ArrayIndexOutOfBoundsException e) {
    }
    Assert.assertArrayEquals(new String[] {"a", "b", "c", "d"}, Arrays.splice(array, -2, 2));
    Assert.assertArrayEquals(new String[] {"a", "b", "c", "f"}, Arrays.splice(array, -3, 2));
    Assert.assertArrayEquals(new String[] {"a", "b", "e", "f"}, Arrays.splice(array, -4, 2));
    Assert.assertArrayEquals(new String[] {"a", "d", "e", "f"}, Arrays.splice(array, -5, 2));
    Assert.assertArrayEquals(new String[] {"c", "d", "e", "f"}, Arrays.splice(array, -6, 2));
    try {
      Arrays.splice(array, -7, 2);
      Assert.fail("Expected ArrayIndexOutOfBoundsException");
    }
    catch (final ArrayIndexOutOfBoundsException e) {
    }

    Assert.assertArrayEquals(new String[] {}, Arrays.splice(array, 0));
    Assert.assertArrayEquals(new String[] {"a"}, Arrays.splice(array, 1));
    Assert.assertArrayEquals(new String[] {"a", "b"}, Arrays.splice(array, 2));
    Assert.assertArrayEquals(new String[] {"a", "b", "c"}, Arrays.splice(array, 3));
    Assert.assertArrayEquals(new String[] {"a", "b", "c", "d"}, Arrays.splice(array, 4));
    Assert.assertArrayEquals(new String[] {"a", "b", "c", "d", "e"}, Arrays.splice(array, 5));
    Assert.assertArrayEquals(new String[] {"a", "b", "c", "d", "e", "f"}, Arrays.splice(array, 6));
    try {
      Arrays.splice(array, 7);
      Assert.fail("Expected ArrayIndexOutOfBoundsException");
    }
    catch (final ArrayIndexOutOfBoundsException e) {
    }

    Assert.assertArrayEquals(new String[] {"a", "b", "c", "d", "e"}, Arrays.splice(array, -1));
    Assert.assertArrayEquals(new String[] {"a", "b", "c", "d"}, Arrays.splice(array, -2));
    Assert.assertArrayEquals(new String[] {"a", "b", "c"}, Arrays.splice(array, -3));
    Assert.assertArrayEquals(new String[] {"a", "b"}, Arrays.splice(array, -4));
    Assert.assertArrayEquals(new String[] {"a"}, Arrays.splice(array, -5));
    Assert.assertArrayEquals(new String[] {}, Arrays.splice(array, -6));
    try {
      Arrays.splice(array, -7);
      Assert.fail("Expected NegativeArraySizeException");
    }
    catch (final NegativeArraySizeException e) {
    }

    Assert.assertArrayEquals(new String[] {"x", "y", "z", "c", "d", "e", "f"}, Arrays.splice(array, 0, 2, "x", "y", "z"));
    Assert.assertArrayEquals(new String[] {"a", "x", "y", "z", "d", "e", "f"}, Arrays.splice(array, 1, 2, "x", "y", "z"));
    Assert.assertArrayEquals(new String[] {"a", "b", "x", "y", "z", "e", "f"}, Arrays.splice(array, 2, 2, "x", "y", "z"));
    Assert.assertArrayEquals(new String[] {"a", "b", "c", "x", "y", "z", "f"}, Arrays.splice(array, 3, 2, "x", "y", "z"));
    Assert.assertArrayEquals(new String[] {"a", "b", "c", "d", "x", "y", "z"}, Arrays.splice(array, 4, 2, "x", "y", "z"));
    try {
      Arrays.splice(array, 5, 2, "x", "y", "z");
      Assert.fail("Expected ArrayIndexOutOfBoundsException");
    }
    catch (final ArrayIndexOutOfBoundsException e) {
    }

    Assert.assertArrayEquals(new String[] {"a", "b", "c", "d", "x", "y", "z"}, Arrays.splice(array, -2, 2, "x", "y", "z"));
    Assert.assertArrayEquals(new String[] {"a", "b", "c", "x", "y", "z", "f"}, Arrays.splice(array, -3, 2, "x", "y", "z"));
    Assert.assertArrayEquals(new String[] {"a", "b", "x", "y", "z", "e", "f"}, Arrays.splice(array, -4, 2, "x", "y", "z"));
    Assert.assertArrayEquals(new String[] {"a", "x", "y", "z", "d", "e", "f"}, Arrays.splice(array, -5, 2, "x", "y", "z"));
    Assert.assertArrayEquals(new String[] {"x", "y", "z", "c", "d", "e", "f"}, Arrays.splice(array, -6, 2, "x", "y", "z"));
    try {
      Arrays.splice(array, -7, 2, "x", "y", "z");
      Assert.fail("Expected ArrayIndexOutOfBoundsException");
    }
    catch (final ArrayIndexOutOfBoundsException e) {
    }
  }