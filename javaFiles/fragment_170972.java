import java.util.*;
public class CensuraLaPrima {

  public static void main(String[] args) {
    Scanner s= new Scanner (System.in);
    String tdc;

    while (s.hasNext()) {
      tdc=s.next();
      char c = tdc.charAt(0);
      System.out.print(tdc.replaceAll(Character.toLowerCase(c) +"|"+  Character.toUpperCase(c), "#"));
    }


}