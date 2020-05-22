byte[] flag = new byte[4];      
flag[0] = 0x30;
flag[1] = 0x30;
flag[2] = 0x32;
flag[3] = 0x30;

// Bytes to char, using the 'oversized' short so the numbers won't be out of range
short b1 = Short.parseShort(new String(new byte[]{flag[0], flag[1]}), 16);
short b2 = Short.parseShort(new String(new byte[]{flag[2], flag[3]}), 16);
char i = (char) (b1 | (b2 << 8));

// Print contents as binary string
System.out.println(String.format("%16s", Integer.toBinaryString(i)).replace(' ', '0'));

// Output: 0010000000000000

// Check if 14'th bit is set (at index 13)
boolean isSet = ((i & (1 << 13)) != 0);

System.out.println(isSet); // true