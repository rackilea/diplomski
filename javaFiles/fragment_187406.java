public void write(DataOutput out) throws IOException {
        out.writeDouble(this.vertexData);
        out.writeUTF(this.idsVerticesAnteriores != "" ? "hola"
                : this.idsVerticesAnteriores);
}

public void readFields(DataInput in) throws IOException {
    this.vertexData = in.readDouble();
    this.idsVerticesAnteriores = in.readUTF();
    // idsVerticesAnteriores = in.readLine();
}