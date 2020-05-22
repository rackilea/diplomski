public class RegularExpression {

public static void main(String[] ar) {
    String str1 = "CC44C";
    String str2 = "C4444C";
    String str3 = "4444C";
    String str4 = "SDFSD123C";
    String pattern = "^[A-Z]{1,2}\\d{1,4}[A-Z]{1}";
    System.out.println(str1+" matches?: "+str1.matches(pattern));
    System.out.println(str2+" matches?: "+str2.matches(pattern));
    System.out.println(str3+" matches?: "+str3.matches(pattern));
    System.out.println(str4+" matches?: "+str4.matches(pattern));
}