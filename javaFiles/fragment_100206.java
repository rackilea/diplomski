import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class ArrayOperations {
    public static void main(String[] args) throws Exception{
            List<Integer> readFromFile = readFromFile("data.txt") ;
            printArray(readFromFile) ;
    }
    public static List<Integer> readFromFile(String fileName)
                                  throws FileNotFoundException
    { 
         File f = new File(fileName);
         Scanner fileIn = new Scanner (f);
         List<Integer> list = new ArrayList<Integer>();
         while (fileIn.hasNextInt()){ // quit when you encounter ‘Q’
            int num = fileIn.nextInt();
            list.add(num);

         }// end while
       fileIn.close();
       return list;
    } // end readFromFile

    public static String printArray( List<Integer> readFromFile){
        String str = "";
        for(int i = 0; i < readFromFile.size(); i++){
            str = str + Integer.toString(readFromFile.get(i)) + " ";
        }
        System.out.println(str);
        return str;
    }
}