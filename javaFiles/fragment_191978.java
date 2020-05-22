import java.util.Scanner;

public class SecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 10 integers separated by single spaces: ");
        String str = sc.nextLine();
        int last = str.lastIndexOf(" ");
        int num = Integer.parseInt(str.substring(0, str.indexOf(" ")));
        int largest = num;
        int secondLargest = num;
        int index = str.indexOf(" ");
        for (int i = 1; i < 10; i++) {
            str = str.substring(index + 1);
            index = str.indexOf(" ");
            if (index != -1) {
                num = Integer.parseInt(str.substring(0, index));
                if (num > largest) {
                    secondLargest = largest;
                    largest = num;
                }
            }
        }
        System.out.println("The second largest number is: " + secondLargest);
    }
}