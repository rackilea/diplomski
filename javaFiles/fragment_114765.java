public class Test {

    public static void main(String[] args) throws Exception {
        RandomAccessFile inputRandomAccessFile = null;
        RandomAccessFile outputRandomAccessFile = null;
        try {
            inputRandomAccessFile = new RandomAccessFile("G:\\file1.zip", "r");
            FileChannel inputFileChannel = inputRandomAccessFile.getChannel();
            outputRandomAccessFile = new RandomAccessFile("G:\\file2.zip", "rw");
            FileChannel outFileChannel = outputRandomAccessFile.getChannel();
            long readFileSize = inputFileChannel.size();
            long transferredSize = 0;
            do {
                long count = inputFileChannel.transferTo(transferredSize, inputFileChannel.size(), outFileChannel);
                transferredSize += count;
            } while (transferredSize < readFileSize);

            inputFileChannel.force(true);
            outFileChannel.force(true);
        } finally {
            if (outputRandomAccessFile != null) {
                outputRandomAccessFile.close();
            }
            if (inputRandomAccessFile != null) {
                inputRandomAccessFile.close();
            }
        }
        System.out.println("DONE");
    }
}