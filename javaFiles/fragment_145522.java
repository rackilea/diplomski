Map<Integer, String> headers = ...
String data = "Hello, world - look at my headers!";

int headerBuffersLength = 0;
List<ByteBuffer> headerBuffers = new ArrayList<>();

for(Integer headerType : headers.keySet())
{
  String headerData = headers.get(headerType);

  ByteBuffer headerBuffer = ByteBuffer.allocation(headerData.size + Integer.BYTES + Integer.BYTES);
  headerBuffer.putInt(headerData.length);
  headerBuffer.putInt(headerType);
  headerBuffer.put(headerData.getBytes("UTF-8"));
  headerBuffer.flip();

  headerBuffers.add(headerBuffer);

  headerBuffersLength += headerBuffer.limit();
}

ByteBuffer buffer = ByteBuffer.allocate(data.length + headerBuffersLength + Integer.BYTES + Integer.BYTES);
buffer.putInt(data.length + headerBuffersLength);    
buffer.putInt(headerBuffers.size());

for (ByteBuffer headerBuffer : headerBuffers)
{
  buffer.put(headerBuffer);
}

buffer.put(data.getBytes("UTF-8"));
buffer.flip();

channel.write(buffer);