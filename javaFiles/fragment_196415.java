package calculator;
import java.util.Scanner;

class Maths {

    double add(double a, double b) {
        double answer = a+b;
        return answer;          
    }

    double subtract(double a, double b) {
        double answer = a-b;
        return answer;          
    }

    double multiply(double a, double b) {
        double answer = a*b;
        return answer;          
    }

    double divide(double a, double b) {
        double answer = a/b;
        return answer;          
    }

    double power(double a, double b){
        double answer =a;

        for (int x=2; x<=b; x++){
            answer *= a;
        }

        return answer;
    }

}

public class Calculator {

public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    Maths maths = new Maths();

    double answer = 0;
    double inputA, inputB;
    char operator;
    boolean done = false;

     while (done == false) {
        System.out.print("Please enter your equation: ");

        inputA = input.nextDouble();
        operator = input.next().charAt(0);
        inputB = input.nextDouble();        

        if (operator == '+') {
            answer = maths.add(inputA, inputB);
        }

        if (operator == '-') {
            answer = maths.subtract(inputA, inputB);
        }

        if (operator == '*') {
            answer = maths.multiply(inputA, inputB);
        }

        if (operator == '/') {
            answer = maths.divide(inputA, inputB);
        }

        if (operator == '^') {
            answer = maths.power(inputA, inputB);
        }

            System.out.println(answer);             
    }       

    input.close();

  }

}