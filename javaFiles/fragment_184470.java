int byteToInt(char* bytes)
{
  int ch1 = bytes[0];
  int ch2 = bytes[1];
  int ch3 = bytes[2];
  int ch4 = bytes[3];
  if ((ch1 | ch2 | ch3 | ch4) < 0)
      WPRINT_APP_INFO ( ("boh\r\n"));
  return ((ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0));
}