// Do this once
private static Schema<Picture> schema = RuntimeSchema.getSchema(Picture.class);
private static final LinkedBuffer buffer = LinkedBuffer.allocate(DEFAULT_BUFFER_SIZE);

// For each Picture you want to serialize...
Picture p = new Picture(100, 200, Picture.JPEG);
byte[] result = ProtobufIOUtil.toByteArray(p, schema, buffer);
buffer.clear();
return result;