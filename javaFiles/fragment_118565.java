@Test
public void testSSNString() {
  String original = "123456789";
  String expected = "896745123";

  char[] in = original.toCharArray();
  char[] out = new char[9];
  out[0] = in[7];
  out[1] = in[8];
  out[2] = in[5];
  out[3] = in[6];
  out[4] = in[3];
  out[5] = in[4];
  out[6] = in[0];
  out[7] = in[1];
  out[8] = in[2];

  assertEquals(expected.toCharArray(), out);
}