import java.util.Scanner;

public class FactorialExample {
    int solve(int n){
        int fact=1;
        for(int i=1;i<=n;i++){
            fact=fact*i;
        }
        return fact;
    }

    public static void main(String[] args) {
        FactorialExample fe=new FactorialExample();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter any Integer Value:");
        int value=sc.nextInt();
        int solution = fe.solve(value);
        System.out.println("tha factorail of a given number is::"+solution);
    }
}