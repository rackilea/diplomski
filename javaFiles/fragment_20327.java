import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Enter expression:");
        Calc calc = new Calc();
        System.out.printf("Result is: " + calc.calc());
    }
}

class Calc {
    public int calc(){
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        String operation = scanner.next();
        int num2 = scanner.nextInt();

        int result = 0;
        switch (operation){
            case "+": result = num1+num2; break;
            case "-": result = num1-num2; break;
            case "*": result = num1*num2; break;
            case "/": result = num1/num2; break;
            default:
                System.out.println("The operation is not recognized. Repeat entry.");
                calc();
        }
        scanner.close();
        return result;
    }
}