import java.io.*;
class CreateFile{

    public static void main(String[] args) throws IOException{
        File f = new File("File/handling/file1.txt");
        if(!f.exists()) {
           f.getParentFile().mkdirs(); // This is a no-op if it exists
           f.createNewFile();
        }
    }
}