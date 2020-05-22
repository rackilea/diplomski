import javax.swing.*;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CandyLand{
   public static void main(String str[]){
      int num1,num2,num3,num4,num5,num6,num7;

      String input1 = JOptionPane.showInputDialog("Please, enter the number of candies in the first pile");
      num1 = Integer.parseInt(input1);
      String input2 = JOptionPane.showInputDialog("Please, enter the number of candies in the second pile");
      num2 = Integer.parseInt(input2);
      String input3 = JOptionPane.showInputDialog("Please, enter the number of candies in the third pile");
      num3 = Integer.parseInt(input3);
      String input4 = JOptionPane.showInputDialog("Please, enter the number of candies in the fourth pile");
      num4 = Integer.parseInt(input4);
      String input5 = JOptionPane.showInputDialog("Please, enter the number of candies in the fifth pile");
      num5 = Integer.parseInt(input5);
      String input6 = JOptionPane.showInputDialog("Please, enter the number of candies in the sixth pile");
      num6 = Integer.parseInt(input6);
      String input7 = JOptionPane.showInputDialog("Please, enter the number of candies in the seventh pile");
      num7 = Integer.parseInt(input7);

      String fileName = JOptionPane.showInputDialog("Please, enter the name of the file");
      try{
         DataOutput f = new DataOutputStream(new FileOutputStream(fileName + ".txt"));
         f.writeBytes(String.valueOf(num1));
         f.writeBytes("\r\n");
         f.writeBytes(String.valueOf(num2));
         f.writeBytes("\r\n");
         f.writeBytes(String.valueOf(num3));
         f.writeBytes("\r\n");
         f.writeBytes(String.valueOf(num4));
         f.writeBytes("\r\n");
         f.writeBytes(String.valueOf(num5));
         f.writeBytes("\r\n");
         f.writeBytes(String.valueOf(num6));
         f.writeBytes("\r\n");
         f.writeBytes(String.valueOf(num7));
      }
      catch(Exception e){
         String msg = e.toString();
         System.out.println(msg);
      }

      Scanner file = null;
      ArrayList<Integer> list = new ArrayList<Integer>();

      try {
        //You should be reading from the first file you created, not OUT1.txt
         file = new Scanner(new File(fileName + ".txt"));
      } 
      catch (FileNotFoundException e) {
         e.printStackTrace();
      }

      while(file.hasNext()){
         if (file.hasNextInt())
            list.add(file.nextInt());
         else file.next();
      }
      try {
        //Instead using System.out.println, use DataOutput like you were using before
         DataOutput f2 = new DataOutputStream(new FileOutputStream("OUT1.txt"));
         for (Integer j: list){
            f2.writeBytes(j + ": ");
            for(int i=1; i<=j; i++){
               f2.writeBytes("* ");
            }
            f2.writeBytes("\r\n");
         }
      }
      catch(Exception e){
         e.printStackTrace();
      }
   }
}