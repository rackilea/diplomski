ByteBuffer byteBuf = ByteBuffer.allocateDirect(10 * 4);
FloatBuffer floatBuf = byteBuf.asFloatBuffer();
floatBuf.put(innerColor);
floatBuf.put(outerColor);
floatBuf.put(innerRadius);
floatBuf.put(outerRadius);
byteBuf.rewind();
glBufferData(..., byteBuf);