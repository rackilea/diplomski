FloatBuffer buf = FloatBuffer.allocate(10);
buf.put(innerColor);
buf.put(outerColor);
buf.put(innerRadius);
buf.put(outerRadius);
buf.rewind();
glBufferData(..., buf);