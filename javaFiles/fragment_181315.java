// convert to ints and xor
int one = (int)byte1[0];
int two = (int)byte2[0];
int xor = one ^ two;

// convert back to byte
byte b = (byte)(0xff & xor);