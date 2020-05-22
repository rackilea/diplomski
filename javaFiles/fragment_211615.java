import java.io.*;
import java.util.Scanner;

public class Main {

final private static int MAX_RECORD_NUMBER = 20;
final private static int RECORD_LENGTH = 71;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Please input the file location and name.");
        String filepath = input.next();
        File file = new File(filepath); 
        //if (file.exists()) System.out.println("EXISTS!"); else System.out.println("DOESN'T EXIST!");

        try {
            RandomAccessFile store = new RandomAccessFile(file, "rw");
            String dummy = "Empty record                                                           ";
            for (int i = 0; i < MAX_RECORD_NUMBER; i++) {
               store.writeUTF(dummy);
            }
        } catch (FileNotFoundException e){
            System.err.println("File cannot be created!");
        } catch (IOException e){
            System.err.println("Couldn't write to file!");
        }
    }
}