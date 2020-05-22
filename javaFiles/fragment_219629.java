@Test
public void replaceTrailingDigits() {
    String str = "sometext2".replaceFirst("\\d*$", Integer.toString(5));
    Assert.assertEquals("sometext5", str);

    str = "sometext226782".replaceFirst("\\d*$", Integer.toString(897623));
    Assert.assertEquals("sometext897623", str);

    str = "sometext".replaceFirst("\\d*$", Integer.toString(4));
    Assert.assertEquals("sometext4", str);
}