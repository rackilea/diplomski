import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] num;
        Scanner scanner=new Scanner(System.in);
        System.out.print("How many integers you want to enter: ");
        int n = 0;
        if(scanner.hasNextInt()) {
            n=scanner.nextInt();
        }
        num=new int[n];
        for(int i=0;i<n;i++) {
            System.out.printf("Enter integer %d: ",i+1);
            if(scanner.hasNextInt()) {
                num[i]=scanner.nextInt();
            }           
        }
        System.out.println(Arrays.toString(num));
    }
}