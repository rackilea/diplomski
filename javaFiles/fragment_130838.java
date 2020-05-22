import java.util.Scanner;   

public class Caser{

    public static String camelCaser(String str){
       char[] strChr = str.toCharArray();
       strChr[0] = Character.toUpperCase(strChr[0]);
       for(int i = 0; i < strChr.length; i++) if (strChr[i] == '_') strChr[i+1] = Character.toUpperCase(strChr[i+1]);
       String reply = new String(strChr);
       reply = reply.replace("_", "");
       return reply;
    }

    public static void main(String[] args){
       Scanner input = new Scanner(System.in);
       System.out.println("String: ");
       String str = input.next();
       System.out.printf("Converting: %s into %s", str, camelCaser(str));
    }
}