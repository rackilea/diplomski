FileChannel fileInputChannel = new FileInputStream(fileInput).getChannel();
    FileOutputStream fos  = new FileOutputStream(fileOutput);
    short[][] data = new short[1201][1201];
    ByteBuffer bb = ByteBuffer.allocateDirect(2884802);
    while (bb.remaining() > 0)
        fileInputChannel.read(bb);
    fileInputChannel.close();
    bb.flip();
    ShortBuffer sb=null;
    if (ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN))
        {
        for (int i=0;i<1201;i++)
            {
            for (int j=0;j<1201;j++)
                {
                fos.write((data[i][j] >> 8) & 0xFF);
                fos.write(data[i][j] & 0xFF);
                }
            }
        }
    else
        {
        for (int i=0;i<1201;i++)
            {
            for (int j=0;j<1201;j++)
                {
                fos.write(data[i][j] & 0xFF);
                fos.write((data[i][j] >> 8) & 0xFF);
                }
            }
        }