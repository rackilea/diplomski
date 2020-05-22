public byte[] ConvertToDsaSignatureToJavaEncoding(byte[] dsa){
  if(dsa.Length!=40)
    throw new ArgumentException("dsa", "DSA signature should always be 40 bytes long");
  // Split into r and s.
  byte[] r = new byte[20];
  Array.Copy(dsa, 0, r, 0, 20);
  byte[] s = new byte[20];
  Array.Copy(dsa, 20, s, 0, 20);

  // Convert to complement-2
  byte[] complementTwoR = ToComplementTwo(r);
  byte[] complementTwoS = ToComplementTwo(s);

  // Build the result
  byte[] res = new byte[complementTwoR.Length + complementTwoS.Length + 6];
  // Sequence{
  res[0] = 0x30;
  res[1] = (byte) (complementTwoR.Length + complementTwoS.Length + 4);
  // Integer (R)
  res[2] = 0x02;
  res[3] = (byte) complementTwoR.Length;
  Array.Copy(complementTwoR, 0, res, 4, complementTwoR.Length);
  // Integer (S)
  res[complementTwoR.Length + 4] = 0x02;
  res[complementTwoR.Length + 5] = (byte) complementTwoS.Length;
  Array.Copy(complementTwoS, 0, res, complementTwoR.Length + 6, complementTwoS.Length);

  return res;
}

public byte[] ToComplementTwo(byte[] d){
// Ensure the top-bit is zero, otherwise remove unneeded zeroes
// - Find non-zero byte
int i = 0;
while (i < d.Length && d[i] == 0) i++;
// - Do we need an extra byte
int extraByte = (d[i] & 0x80) == 1 ? 1 : 0;
// - Build the result
byte[] res = new byte[d.Length-i+extraByte];
Array.Copy(d, i, res, extraByte, d.Length-i);
return res;