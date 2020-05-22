final byte red = 1; // 01 binary
final byte green = 2; // 10 binary
final byte blue = 3; // 11 binary

final byte finalColor = (byte) ((red & 0x3) << 4) | ((green & 0x3) << 2) | (blue & 0x3);
System.out.println(finalColor);// finalColor is 011011 = 27 decimal

final int minutes = 0x1234; // first byte is 0x12, second byte is 0x34
final byte[] bytes = {(byte) (((minutes) >>> 8) & 0xff), (byte) (minutes & 0xff)};

System.out.println(bytes[0]); // 0x12 = 18 decimal
System.out.println(bytes[1]); // 0x34 = 52 decimal