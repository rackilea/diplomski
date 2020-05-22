import java.util.ArrayList;

public class SecondProgram {

    private static ArrayList <String>file = new ArrayList();

    public synchronized boolean  writeFile(String str){
        //wrtite file to your list
        file.add(str);
        return true;
    }
    public static void main(String args[]) {
        //read file and use the synchronized method to write it to your list
    } 
}