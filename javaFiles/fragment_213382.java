import java.util.Scanner;

class NearZero {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int number;
        int nearNumberZero = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.println("Enter number " + i);
            number = scn.nextInt();
            // by default first is nearest or it will check for other numbers
            if (i == 1 || Math.abs(number) < Math.abs(nearNumberZero))
                nearNumberZero = number;
        }
        System.out.println("The number near zero 0 is - " + nearNumberZero);
        scn.close();//prefer closing your resources (with a try-finally preferrable)
    }

}