long l = 0x0FEDCBA987654321L;

// i = 0x87654321
int i = (int) (l & 0xFFFFFFFFL);

// c = \u4321
char c = (char) (l & 0xFFFF);

// s = 0x4321
short s = (short) (l & 0xFFFF);

// b = 0x21
byte b = (byte) (l & 0xFF);