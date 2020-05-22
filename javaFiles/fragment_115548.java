import java.io.*;
import java.util.*;

public class SumNumbers {

public static void main(String args[]){
    try{
        File f = new File(args[0]);
        Scanner scanner = new Scanner(f);
        int sum = 0;
        while (scanner.hasNext()){
            sum += scanner.nextInt();
        }
        System.out.println("Sum:"+sum); 
    }catch(Exception err){
        err.printStackTrace();
    }

}
}