@Override
public void readFields(DataInput in) throws IOException {
    id = in.readLong();
    text = in.readUTF();
    createdAt = in.readLong();
}

@Override
public void write(DataOutput out) throws IOException {
    out.writeLong(id);
    out.writeUTF(text);
    out.writeLong(createdAt);
}