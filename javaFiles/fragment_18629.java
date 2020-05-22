ByteCountSerializer counter = new ByteCountSerializer();
dataFrame.serialize(counter);
ByteBufferSerializer serializer = new ByteByfferSerializer(counter.position());
dataFrame.serialize(serializer);
ByteBuffer buffer = serializer.buffer();
// ... write buffer, ?, profit ...