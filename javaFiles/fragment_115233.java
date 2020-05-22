public int read(byte[] data, int offset, int len)
   {
      try
      {
         ByteBuffer buffer = ByteBuffer.allocate(len - offset);
         while (buffer.hasRemaining())
         {
            int read_len = client.read(buffer);
            if (read_len == -1)
               return -1;
         }
         buffer.flip();
         int result = buffer.remaining();
         buffer.get(data, offset, buffer.remaining());
         return result;
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
      return -2;
   }