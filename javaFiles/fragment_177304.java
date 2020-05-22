byte[] buffer = new byte[1024];
int len;
while ((len = i.read(buffer)) != -1) {
    os.write(buffer, 0, len);
    os.flush;
}