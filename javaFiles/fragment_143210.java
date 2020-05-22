BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("test_file"));
    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("test_out"));

    int CHUNK_SIZE = 512; // change to 8096
    int startPos = 1012;
    int endPos = 2134;
    int bytesToRead = endPos - startPos;
    int b;
    byte[] buff = new byte[CHUNK_SIZE];
    bufferedInputStream.skip(startPos - 1);
    int currentChunkSize = Math.min(CHUNK_SIZE, bytesToRead);
    while ((b = bufferedInputStream.read(buff, 0, currentChunkSize)) != -1) {
        bufferedOutputStream.write(buff, 0, b);
        System.out.println("Writing " + b);
        bytesToRead -= b;
        if (bytesToRead == 0) {
            break;
        }
        currentChunkSize = Math.min(CHUNK_SIZE, bytesToRead);
    }

    bufferedInputStream.close();
    bufferedOutputStream.close();