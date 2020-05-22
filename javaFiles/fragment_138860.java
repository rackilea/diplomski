import java.io.*;
class FileDemo {
    public static void main(String args[]) {
        //this will close the resources automatically
        //even if an exception rises
        try (FileReader fr = new FileReader("1.txt");
             FileWriter fw = new FileWriter("2.txt")) {
            int c = fr.read();
            while(c!=-1) {
                fw.write(c);
                c = fr.read();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}