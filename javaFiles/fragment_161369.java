byte a = (byte) 0b01111110; // 0b01111110 = 126
byte b1 = (byte) (a << 1);  // 0b11111100 =  -4  <-- overflow
byte c1 = (byte) (a >> 1);  // 0b00111111 =  63
byte b2 = (byte) (b1 >> 1); // 0b11111110 =  -2  <-- sign extension
byte c2 = (byte) (c1 << 1); // 0b01111110 = 126

byte x = (byte) (b1 >>> 1); // 0b01111110 = 126  <-- no sign extension