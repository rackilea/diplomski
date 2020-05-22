public String readUTF8String() throws ImageFileFormatException, IOException
 {
     short len = readInt16();
     if (len == -1)
         return null;
     if (len == 0)
         return "";
     if (len < -1)
         throw new ImageFileFormatException("Invalid UTF8 string");
     byte[] utf8Bytes = readBytes(len);
     return new String(utf8Bytes, "UTF-8");
 }