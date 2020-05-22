RandomAccessFile raf = null;

try {
    raf = new RandomAccessFile(new File("C:/Test.txt"), "rw");
    raf.seek(3);
    raf.writeBytes("BB");
} catch (IOException exp) {
    exp.printStackTrace();
} finally {
    try {
        raf.close();
    } catch (Exception e) {
    }
}