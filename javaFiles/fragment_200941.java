package com.Calculator;

public class CalcModel {

private double calcValue;

public void calculate(double firstNumber, double secondNumber,
        String operator) {

    if (operator.equals("+")) {

        calcValue = firstNumber + secondNumber;

    }

    if (operator.equals("-")) {

        calcValue = firstNumber - secondNumber;

    }
    if (operator.equals("*")) {

        calcValue = firstNumber * secondNumber;

    }
    if (operator.equals("/")) {

        calcValue = firstNumber / secondNumber;

    }

    if (operator.equals("^")) {

        calcValue = Math.pow(firstNumber, secondNumber);

    }
}

public double getCalcValue() {

    return calcValue;

}

}