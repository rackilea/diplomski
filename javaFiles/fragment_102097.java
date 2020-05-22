while(read < length) {
    int numread = is.read(b, read, length - read);
    if (numread < 0)
        break;
    read += numread;
}