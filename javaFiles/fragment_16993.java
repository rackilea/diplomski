@Test
public void test() {
    StringBuffer sb1 = new StringBuffer("hello");
    StringBuffer sb2 = sb1;

    assertTrue(sb1 == sb2);  // this will pass, same object reference

    sb2 = new StringBuffer("hello");  // create a new object

    assertFalse(sb1 == sb2);  // this will be false, since the objects may be equal, but the references are not.
}