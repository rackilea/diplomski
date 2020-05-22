import java.util.Scanner;

public class Try {
    public static void main(String[] args) {

        String c;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string main string1:\n"); //Main String
        String a = scanner.nextLine();
        System.out.println("Enter the substring 1:\n");
        String b = scanner.nextLine();
        String strNew = a.replaceFirst(b, ""); // strNew is after removing substring b
        System.out.println("New string1 "+strNew);
        System.out.println("Enter the substring 2:\n");
        String b1 = scanner.nextLine();
        String strNew1 = strNew.replaceFirst(b1, "");//strNew1 is after removing substring b1
        System.out.println("New string2 "+strNew1);
        System.out.println("Enter the substring 3:\n");
        String b2 = scanner.nextLine();
        String strNew2 = strNew1.replaceFirst(b2, "");//strNew is after removing substring b2
        System.out.println("New string1 "+strNew2);
        System.out.println("Lenght of substring is"+strNew2.length()); //Final length of substring

    }

}