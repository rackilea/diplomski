import java.util.Scanner;

public class DrawRectangle{
    public static void main (String [] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter an integer greater 1 for the length");
        int length = keyboard.nextInt();
        draw_rectangle(length);
        System.out.print(length); // This was rectangle but will print out whatever int the user entered   
    }
    public static void draw_rectangle(int m) {
        for(int star = 0; star < m; star++) System.out.print("*");
        System.out.print("\n*");
        for(int space = 0; space < m-2; space++) System.out.print(" ");
        System.out.print("*\n");
        for(int star = 0; star < m; star++) System.out.print("*");
        System.out.println();
    }
}