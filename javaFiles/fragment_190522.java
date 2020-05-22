import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
class MyClass {
    public static void main (String[] args) {
       try {
                int x = Scanner();
                if(x >= 1 && x <= 49) {
                    System.out.println("Yes");
                }
                else {
                    System.out.println("No");
                }
        }
        catch(java.lang.NumberFormatException e) {
            System.out.println(e);
        }
        //Second Method Using Regex.
        try {
            int x = useRegex();
                if(x >= 1 && x <= 49) {
                    System.out.println("Yes");
                }
                else {
                    System.out.println("No");
                }
        } catch(java.lang.NumberFormatException e) {

            System.out.println(e);
        }
    }
    public static int Scanner() {
        Scanner s = new Scanner(System.in);
        String eingabe = s.nextLine();
        return Integer.parseInt(eingabe);
    }

    public static int useRegex() {
        Scanner s2 = new Scanner(System.in);
        String eingabe = s2.nextLine();
        Pattern p = Pattern.compile("^[\\+-]?\\d+$");
        Matcher m = p.matcher(eingabe);
        boolean b = m.matches();
        if(b) {
            return Integer.parseInt(eingabe);
        }

        else {
            throw new java.lang.NumberFormatException();
        }
    }

}