import java.util.*;

 public class DecToBin {
 public static void main(String[] args){

    int no1;

    Scanner s = new Scanner(System.in);
    no1 = s.nextInt();




    String binNum = "";
    while(no1 > 0){

        int holder = no1 % 2;
        System.out.println(holder);
        binNum.concat(Integer.toString(holder));
        no1 /= 2;



    }
    String actual = new StringBuilder(binNum).reverse().toString();
    System.out.println("Your number is binary is: " + actual);

   }
}