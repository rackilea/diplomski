import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Calculator {
  public static void main(String[] args){
    Scanner imp = new Scanner(System.in);
    System.out.println("yes> ");


    while (true) {
      String s = imp.nextLine();//put getting the input inside the loop or it's infinite

      if (s.equals("bye")) {
          System.exit(0);
      }

      Matcher x = Pattern.compile("add\\s(\\d+)\\s(\\d+)\\stogether").matcher(s); //format add 12 12 together
      Matcher y = Pattern.compile("subtract\\s(\\d+)\\sfrom\\s(\\d+)").matcher(s); //format subtract 05 from 13
      Matcjer z = Pattern.compile("add\\s(\\d+)\\sto\\s(\\d+)").matcher(s); //format add 02 to 03


      boolean l = x.matches();
      boolean i = y.matches();
      boolean g = z.matches(); 

      if (l){
        System.out.println(l.group(1) + " + " + l.group(2) + " = " + 
             (Integer.parseInt(l.group(1))+Integer.parseInt(l.group(2))) );
      }else if (i){
        System.out.println(i.group(1) + " - " + i.group(2) + " = " + 
             (Integer.parseInt(i.group(1))+Integer.parseInt(i.group(2))) );
      }else if (g){
        System.out.println(g.group(1) + " + " + g.group(2) + " = " + 
             (Integer.parseInt(g.group(1))+Integer.parseInt(g.group(2))) );
      }
    }
  }
}