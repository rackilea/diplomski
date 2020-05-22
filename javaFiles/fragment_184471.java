int byteToInt(char* bytes)
{
  uint8_t ch1 = bytes[0];
  uint8_t ch2 = bytes[1];
  uint8_t ch3 = bytes[2];
  uint8_t ch4 = bytes[3];
  return ((ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0));
}