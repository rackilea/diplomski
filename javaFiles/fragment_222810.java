public class FileInputHelper implements Closeable {
    private FileInputStream fileInputStream;
    private BufferedReader fileBufferedReader;
    private int next;

    public FileInputHelper(File file) throws IOException {
        fileInputStream = new FileInputStream(file);
        fileBufferedReader = new BufferedReader(
               new InputStreamReader(fileInputStream));
        next = fileInputStream.read();
    }


    public byte readByte() throws IOException {
        int cur = next;
        next = fileInputStream.read();
        if(cur == -1) {
            throw new IOException("End of file reached");
        }
        return (byte) cur;
    }

    public char read() throws IOException {
        int cur = next;
        next = fileInputStream.read();
        if(cur == -1) {
            throw new IOException("End of file reached");
        }
        return (char) cur;
    }

    public String readLine() throws IOException {
        return fileBufferedReader.readLine();
    }

    @Override
    public void close() throws IOException{
        fileInputStream.close();
    }

    // Returns true if there are more chars / bytes to read.
    public boolean available() {
        return next != -1;
    }

}