private volatile Deserializer<byte[]> packetDeserializer = new ByteArrayLfSerializer();

private volatile Serializer<byte[]> packetSerializer = new ByteArrayLfSerializer();


@Override
public Map<?, ?> deserialize(InputStream inputStream) throws IOException {
    byte[] bytes = readToEndOfMessage(inputStream);
    String asString = new String(bytes, "UTF-8");
    Map<String, String> headers = new HashMap<String, String>();
    headers.put("issuer", asString.substring(0, 5));
    headers.put("client", asString.substring(4, 9));
    headers.put("product", asString.substring(9, 11));
    headers.put("type", asString.substring(11, 14));
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("headers", headers);
    map.put("payload", createPayloadFromRemainingBytes(bytes));
    return map;
}

@Override
public void serialize(Map<?, ?> object, OutputStream outputStream) throws IOException {
    Map<String, String> headers = (Map<String, String>) object.get("headers");
    outputStream.write(headers.get("issuer").getBytes("UTF-8"));
    outputStream.write(headers.get("client").getBytes("UTF-8"));
    outputStream.write(headers.get("product").getBytes("UTF-8"));
    outputStream.write(headers.get("type").getBytes("UTF-8"));
    outputStream.write(convertPayloadToBytes(object.get("payload")));
}