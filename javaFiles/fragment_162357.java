public class MyFile {
    File file;
    String fileName;

    public MyFile(File file)
    {
        this.file = file;
        this.fileName = file.getName();
        fileName = fileName.substring(0, fileName.lastIndexOf('.'));
    }

    @Override
    public String toString() {
        return this.fileName;
    }
}