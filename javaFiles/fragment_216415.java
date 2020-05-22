private static int calcCRC32(byte[] raw, int offset, int len) throws IOException
{
      CRC32 crc32 = new CRC32();
      crc32.update(raw, offset, len);
      return (int)crc32.getValue();
}