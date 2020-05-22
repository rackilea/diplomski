import java.util.*;
import java.util.regex.*;
import java.io.*;
public class Sample{
public static void main(String[] args){
  try{
          File inFile = new File ("phonebook.txt");

          Scanner sc = new Scanner (inFile);
          while (sc.hasNextLine())
          {
            String line = sc.nextLine();
            if(line.matches("^((.)*\\s)?((\\+|00)359|0)8[7-9][2-9]\\d{6}$")) // here that code doesn't work
            {
            System.out.println (line);
            }
          }
          sc.close();
}catch(Exception e){}
        }
}