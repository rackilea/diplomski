byte[] buffer = new byte[4096];
int bytesRead = 0;
while ((bytesRead = source.read(buffer)) != -1) {
    out.write(buffer, 0, bytesRead);
    loopCounter++;
}