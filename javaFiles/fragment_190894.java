i = localFileInputStream.read();
if (i != -1)
    continue;
localFileInputStream.close();
if ((char) i == 'v') {
    i = localFileInputStream.read();