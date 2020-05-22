import java.io.*;
public class Sequence {
    public static void main(String[] args) throws IOException {
    DataInputStream dis = new DataInputStream(System.in);
    String str="Enter your Age :";
    System.out.print(str);
    int i=dis.readInt();
    System.out.println((int)i);
    }
}