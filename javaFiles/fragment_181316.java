String a        = "10101010";
String b        = "01010101";
String expected = "11111111";  // expected result of a ^ b

int aInt = Integer.parseInt(a, 2);
int bInt = Integer.parseInt(b, 2);
int xorInt = Integer.parseInt(expected, 2);

byte aByte = (byte)aInt;
byte bByte = (byte)bInt;
byte xorByte = (byte)xorInt;

// conversion routine compacted into single line
byte xor = (byte)(0xff & ((int)aByte) ^ ((int)bByte));


System.out.println(xorInt + "   // 11111111  as integer");
System.out.println(xorByte + "    // 11111111  as byte");

System.out.println(aInt + "   // a as integer");
System.out.println(bInt + "    // b as integer");
System.out.println((aInt ^ bInt) + "   // a ^ b as integers");

System.out.println(aByte + "   // a as byte");
System.out.println(bByte + "    // b as byte");

System.out.println(xor + "    // a ^ b as bytes");