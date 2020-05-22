@Override
public void readFields(DataInput in) throws IOException {
    movieId = in.readUTF();
    movieTitle = in.readUTF();
}

@Override
public void write(DataOutput out) throws IOException {
    out.writeUTF(movieId);
    out.writeUTF(movieTitle);
}