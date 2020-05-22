@Test(expected = ArrayIndexOutOfBoundsException.class)
public void test() {
    // GIVEN
    final int[] array = new int[10];

    // WHEN
    final int value = array[10];

   // THEN: an ArrayIndexOutOfBoundsException should be thrown
}