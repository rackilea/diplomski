OutputStream os = response.getOutputStream();
byte[] buffer = new byte[chunk];
int bytesRead = -1;

while ((bytesRead = base64InputStream.read(buffer)) != -1) {
    os.write(buffer, 0, bytesRead);
}