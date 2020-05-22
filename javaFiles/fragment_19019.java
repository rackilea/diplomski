byte bitMask;
int varInt1 = 3;
final int finalVarInt2 = 3;
final int finalVarInt3 = 4;

bitMask = 0x8>>varInt1;    // 1. Will not work. 
bitMask = 0x8<<3;          // 2. Will work

bitMask = 0x8<<4;          // 3. Will not work
bitMask = 0x8<<finalVarInt2;   // 1. Will work
bitMask = 0x8<<finalVarInt3;   // 2. Will not work