read_bit(int bit) {
 return (bitpack >> bit) & 0x01;
}

write_bit(int bit, int value) {
 bitpack = (bitpack) | ((value & 0x01) << bit);
}