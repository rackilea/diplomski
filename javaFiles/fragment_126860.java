ByteArrayOutputStream baos = new ByteArrayOutputStream();
byte[] buffer = new byte[32 * 1024];

int bytesRead;
while ((bytesRead = System.in.read(buffer)) > 0) {
    baos.write(buffer, 0, bytesRead);
}
byte[] bytes = baos.toByteArray();