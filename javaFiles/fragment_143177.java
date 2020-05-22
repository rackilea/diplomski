public void write(DataOutput out) throws IOException {
    out.writeFloat(floatone.get());
    out.writeFloat(floattwo.get());
}

public void readFields(DataInput in) throws IOException {
    floatone = new FloatWritable(in.readFloat());
    floattwo = new FloatWritable(in.readFloat());
}