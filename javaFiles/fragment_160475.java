int toBeRead = in.available();
byte[] b = new byte[toBeRead];
int totalRead = 0;
int read;
while ((read = in.read(b, totalRead, toBeRead-totalRead)) != -1) {
    totalRead += read;
}