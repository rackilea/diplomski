public class SampleCode { 

  public static void main(String[] args ) {

  //String[]args2 = {"en", "es"};

  if( args[0].equals("en")) {
    System.out.println("english option");
 }
 else if( args[1].equals("es")) {
    System.out.println("spanish option");
 }
 else { System.out.println("this is the default option");}

 }
}