int a = 21;
int b = 269;

int shift = Integer.numberOfLeadingZeros(a) - Integer.numberOfLeadingZeros(b);

int c = (a << shift) ^ b;
System.out.println(Integer.toBinaryString(c)); // 1011101