FileInputStream is = new FileInputStream(image);
ByteArrayOutputStream buffer = new ByteArrayOutputStream();

int nRead;
byte[] data = new byte[16384];
while ((nRead = is.read(data, 0, data.length)) != -1) {
    buffer.write(data, 0, nRead);
}
buffer.flush();
byte[] fileInBytes = buffer.toByteArray();

Response response = target.request().post(Entity.entity(fileInBytes, 
        MediaType.APPLICATION_OCTET_STREAM));