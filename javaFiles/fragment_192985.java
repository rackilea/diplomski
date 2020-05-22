@Test
  public void testExceptionMessage() {
      try {
          new ArrayList<Object>().get(0);
          fail("Expected an IndexOutOfBoundsException to be thrown");
      } catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
          assertThat(anIndexOutOfBoundsException.getMessage(), is("Index: 0, Size: 0"));
      }
  }