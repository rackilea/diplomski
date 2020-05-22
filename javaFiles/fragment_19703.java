public static byte[] encode(BSONObject bsonObject) {
    BSONEncoder encoder = new BasicBSONEncoder();
    return encoder.encode(bsonObject);
}

public static BSONObject readObject(InputStream is) throws IOException {
    BasicBSONDecoder encoder = new BasicBSONDecoder();
    return encoder.readObject(is);
}

public static BSONObject readObject(byte[] bsonObject) {
    BasicBSONDecoder encoder = new BasicBSONDecoder();
    return encoder.readObject(bsonObject);
}