import java.util.Scanner;
public class Test{
public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println();
        String User = sc.nextLine();
        char [] pass = System.console().readPassword();
        System.out.println(pass);
        char c = sc.next().charAt(0);
        System.out.println(c);
        String d = sc.next();
        boolean Contained;
        if(d.contains("a")){
           Contained = true;
        }
        else{ Contained = false; }
        System.out.println(d);
        System.out.println("Contains a ? " + Contained); 
        char b = sc.next().charAt(0);
        System.out.println(b);
        System.out.println(User);
} 
}