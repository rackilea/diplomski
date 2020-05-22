[stephen@blackbox tmp]$ cat Test.java 
import java.util.*;                                                                                                                                           
import java.io.*;

public class Test {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        Scanner in = null;
        try{
            String fname = "test.txt";
            in = new Scanner(new File(fname));
        }catch (FileNotFoundException pExcept){
            System.out.println("Sorry, the File you tried to open does not exist. Ending program.");
            System.exit(-1);
        }

        while (in.hasNextInt())
            {
                int x = in.nextInt();
                list.add(x);
            }
        System.out.println("Read " + list.size() + " numbers");
    }
}
[stephen@blackbox tmp]$ cat test.txt 
2 8 3

2 9

8

6

3 4 6 1 9
[stephen@blackbox tmp]$ javac Test.java 
[stephen@blackbox tmp]$ java Test 
Read 12 numbers
[stephen@blackbox tmp]$