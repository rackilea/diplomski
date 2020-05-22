// float[] floats
new ArrayPrimitiveWritable(floats).write(out);


ArrayPrimitiveWritable apw = (float[]) new ArrayPrimitiveWritable().readFields(in);
float[] floats = (float[]) apw.get();