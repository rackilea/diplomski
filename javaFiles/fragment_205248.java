String encoded; // from your request parameters or whatever
encoded = encoded.replace('.', '+')
        .replace('_', '/')
        .replace('-', '=');
ByteBuffer uuidBuffer = ByteBuffer.wrap(Base64.decode(
        encoded.getBytes(Charset.forName("US-ASCII"))));
LongBuffer longBuffer = uuidBuffer.asLongBuffer();
UUID uuid = new UUID(longBuffer.get(), longBuffer.get());