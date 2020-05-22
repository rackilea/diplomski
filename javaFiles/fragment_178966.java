public static void main(String[] args) throws IOException {
    int senderSequenceNumber=1910;
    int targetSequenceNumber=2268;
    RandomAccessFile file  = new RandomAccessFile("C:\\filename.seqnums", "rw");
    file.seek(0);
    file.writeUTF("" + senderSequenceNumber + ':'+ targetSequenceNumber);
}