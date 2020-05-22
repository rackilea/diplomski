import java.util.Scanner;

public class Pratclass1 {

public static void main(String[] args) {
Scanner std= new Scanner(System.in);
String string1;
System.out.print("What is your name :");
string1= std.nextLine();

int count= 0;
int vowels=0;

char[] ar = new char[string1.length()];

for(int i = 0; i < ar.length; i++) {
    ar[i] = string1.charAt(i);
    if(ar[i] == 'a' || ar[i] == 'e' || ar[i] == 'i' || ar[i] == 'o'|| ar[i] == 'u') {
        vowels++;
    } else {
        count++;
    }
}

int total=vowels;
System.out.println();
System.out.println(total);
}