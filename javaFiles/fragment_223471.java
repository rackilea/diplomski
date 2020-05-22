@Test
public void serialized_form()
{
  Verify.assertSerializedForm(
    -7019839295612785318L,
    "rO0ABXNyAC9jYXJhbWVsa2F0YS5zaHVrbmlfZ29lbHZhLkV4ZXJjaXNlOVRlc3QkTXlDbGFzc56U\n"
      + "hVp0q+1aAgAAeHA=",
    new MyClass());
}