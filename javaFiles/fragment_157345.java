import java.util.ArrayList;
import java.util.Scanner;

public class aa {

    public static void main(String[] args) {
        Scanner scn =new Scanner(System.in);
        String str=scn.nextLine();
       printSub(str,"");

    }
    public static void  printSub(String str,String pre) {

        if(str.length()==0){
           System.out.println(pre);
          return;
        }

         printSub(str.substring(1),pre);

         printSub(str.substring(1),pre+Character.toString(str.charAt(0)));

    }
}