import java.util.regex.*;
public class Test{
  public static void main(String[] args){
    String mob="+359878123456"; 
    Pattern p2 = Pattern.compile("^((\\+|00)359|0)(\\-|\\s)?8[7-9][2-9](\\-|\\s)?\\d{3}(\\s|\\-)?\\d{3}$");
    boolean b = p2.matcher("+359-878-123456").matches();
    if(b) System.out.println("True1");

    b = p2.matcher("+359 878 123 456").matches();
    if(b) System.out.println("True2");

    b = p2.matcher("+359-878-123-456").matches();
    if(b) System.out.println("True3");

    b = p2.matcher("+359-878123456").matches();
    if(b) System.out.println("True4");

    b = p2.matcher("00359-878123456").matches();
    if(b) System.out.println("True5");

    b = p2.matcher("0-878-123456").matches();
    if(b) System.out.println("True6");

    b = p2.matcher("+359878123456").matches();
    if(b) System.out.println("True7");

    b = p2.matcher("359878123456").matches(); // without + or 00
    if(b) System.out.println("True8");
    else System.out.println("FALSE8");

    b = p2.matcher("123478123456").matches(); 
    if(b) System.out.println("True9");
    else System.out.println("FALSE9");

  }
}