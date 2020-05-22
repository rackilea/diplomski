int cur = fileInputStream.read();
if(cur == -1) {
    throw new EOFException("End of input reached");
}else {
    return (char) cur;
}