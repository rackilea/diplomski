int a = 2;
fo.write(a); //This line write the byte 0x02 to the inputstream because that is the binary representation of the digit 2

String s = "2";
byte b[] = s.getBytes();
fo.write(b); //This one write 0x32 to the inputstream because that is the ascii respresentation of the character "2" which is return by getBytes() from the string class