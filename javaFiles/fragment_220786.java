public class FileDeleteExample {
    public static void main(String[] args) throws Exception {
        File f = new File("test.txt");

        FileOutputStream outFile = null;

        try {
            outFile = new FileOutputStream(f);
            outFile.write("Test".getBytes());
        } finally {
            outFile.flush();
            outFile.close();
            outFile = null;
            System.gc();
        }

        f.delete();
    }
}