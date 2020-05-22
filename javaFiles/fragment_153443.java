package THE_JNOTE_PROJECT;
import java.util.*;

class Swap {
public static void main (String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter a string");
    String s = in.nextLine();
    int l=(s.length())/2;
    char ar[]=new char[l];
    char data[]=new char[s.length()-l];
    s.getChars(0,l,ar,0);
    s.getChars(l,s.length(),data,0);
    String first=new String(ar);
    String sec=new String(data);
    System.out.println(sec.concat(first));
}
}