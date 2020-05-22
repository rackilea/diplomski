public static void copy(InputStream in, OutputStream out , int bufferSize)
           throws IOException
        {
           // Read bytes and write to destination until eof
           byte[] buf = new byte[bufferSize];
           int len = 0;
           while ((len = in.read(buf)) >= 0)
           {
              out.write(buf, 0, len);
           }
        }