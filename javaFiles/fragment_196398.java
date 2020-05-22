import java.util.*;
import java.math.*;
import java.io.*;

class Test {
    public static void main(String[] args)throws IOException {
        File f = new File("custy.txt");
        Scanner in = new Scanner(f);
        while(in.hasNext() ){
            int id = in.nextInt();
            String name = in.next();
            String email = in.next();
            double balance = in.nextDouble();
            in.nextLine();

            System.out.println(id + " " + name + " " + email + " " + balance);
        }
        in.close();
    }    
}