byte[] buffer = {1,2,3,4,5};
InputStream is = new ByteArrayInputStream(buffer);

byte[] chunk = new byte[2];
while(is.available() > 0) {
    int count = is.read(chunk);
    if (count == chunk.length) {
        System.out.println(Arrays.toString(chunk));
    } else {
        byte[] rest = new byte[count];
        System.arraycopy(chunk, 0, rest, 0, count);
        System.out.println(Arrays.toString(rest));
    } 
}