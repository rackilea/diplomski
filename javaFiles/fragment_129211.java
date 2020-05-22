RandomAccessFile randomAccessFile = new RandomAccessFile("the.log", "r");
    long offset = randomAccessFile.length() - 1;

    int found = 0;
    while (offset > 0 && found < 10) {
        randomAccessFile.seek(offset--);
        if (randomAccessFile.read() == 10) {
            found++;
        }
    }
    System.out.println(randomAccessFile.readLine());