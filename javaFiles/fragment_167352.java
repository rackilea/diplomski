int bytesRead = 0;
byte[] buffer = new byte[1024]; // reads up to 1024 byte chunks
while((bytesRead = in.read(buffer)) != -1) {
    for ( int i = 0; i < bytesRead; i++ ) {
        input += Integer.toHexString(buffer[i]);
    }

    handleInput(input);
}