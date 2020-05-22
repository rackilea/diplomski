char[] buf = new char[159];
int charsRead = 0;
while (charsRead < buf.length) {
    int count = reader.read(buf, charsRead, buf.length - charsRead);
    if (count < 0) {
        throw new EOFException();
    }
    charsRead += count;
}
// Right, now you know you've actually read 159 characters...