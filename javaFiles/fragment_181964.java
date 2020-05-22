import java.util.Scanner;


/**
 *
 * @author john
 */
 public class Lab3 {


 public static void main(String[] args) {
     String c;
     Lab3 classy  = new Lab3();
     Scanner input=new Scanner(System.in);

          System.out.print("Which character would you like to display?");

          c = input.next();

        System.out.println("My name is Jonathan");
        classy.displayLetterJ(c);
        classy.displayLetterO(c);
        classy.displayLetterN(c);
        classy.displayLetterA(c);
        classy.displayLetterT(c);
        classy.displayLetterH(c);
        classy.displayLetterA(c);
        classy.displayLetterN(c);

      }//end of main
public void displayLetterJ(String c) {
    System.out.println("  "+c+c+c);
    System.out.println("    " +c);
    System.out.println("    " +c);
    System.out.println(c + "   " + c);
    System.out.println(c+ c+ c + c +c);

 }
 public void displayLetterA(String c){
    System.out.println();
    System.out.println("   "+c);
    System.out.println("  "+c+" "+c);
    System.out.println(" "+c+" "+c+" "+c);
    System.out.println(c+"     "+c);
    System.out.println(c+"     "+c);

}
  public void displayLetterO(String c){
    System.out.println();
    System.out.println("  "+c+c);
    System.out.println(" "+c+"  "+c);
    System.out.println(c+"    "+c);
    System.out.println(c+"   "+c);
    System.out.println("  "+c+c);

}
  public void displayLetterN(String c){
    System.out.println();
    System.out.println(c+"    "+c);
    System.out.println(c+" "+c+"  "+c);
    System.out.println(c+"  "+c+" "+c);
    System.out.println(c+"   "+c+c);
    System.out.println(c+"    "+c);

}
 public void displayLetterH(String c){//H accessor
    System.out.println();
    System.out.println(c+"   "+c);
    System.out.println(c+"   "+c);
    System.out.println(c+c+c+c+c);
    System.out.println(c+"   "+c);
    System.out.println(c+"   "+c);

}
  public void displayLetterT(String c){
    System.out.println();
    System.out.println(c+c+c+c+c);
    System.out.println("  "+c);
    System.out.println("  "+c);
    System.out.println("  "+c);
    System.out.println("  "+c);

    }