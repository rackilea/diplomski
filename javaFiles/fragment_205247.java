UUID uuid = UUID.randomUUID();
ByteBuffer uuidBuffer = ByteBuffer.allocate(16);
LongBuffer longBuffer = uuidBuffer.asLongBuffer();
longBuffer.put(uuid.getMostSignificantBits());
longBuffer.put(uuid.getLeastSignificantBits());
String encoded = new String(Base64.encode(uuidBuffer.array()), 
        Charset.forName("US-ASCII"));
encoded = encoded.replace('+', '.')
        .replace('/', '_')
        .replace('=', '-');