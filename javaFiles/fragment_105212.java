@Test(expected = ArrayIndexOutOfBoundsException.class)
void test() {
    // GIVEN
    final int[] array = new int[10];

    // WHEN
    final Exception e = assertThrows(ArrayIndexOutOfBoundsException.class,
            () -> {
                int value = array[10];
            }
    );

   // THEN
   assertTrue(e.getMessage().contains("10"));
}