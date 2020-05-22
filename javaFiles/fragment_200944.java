package com.Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {

private CalcGui theGui;
private CalcModel theCalcModel;
private SqrtCalcModel theSqrtCalcModel;
private QuadraticCalcModel theQuadraticCalcModel;

public CalculatorController(CalcGui theGui, CalcModel theCalcModel,
        SqrtCalcModel theSqrtCalcModel,
        QuadraticCalcModel theQuadraticCalcModel) {
    this.theGui = theGui;
    this.theCalcModel = theCalcModel;
    this.theSqrtCalcModel = theSqrtCalcModel;
    this.theQuadraticCalcModel = theQuadraticCalcModel;

    this.theGui.addCalculateListener(new CalcListener());
    this.theGui.addSqrtCalcListener(new SqrtCalcListener());
    this.theGui.addQuadraticCalcListener(new QuadraticCalcListener());
}

class CalcListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {

        double firstNumber, secondNumber = 0;
        String operator;

        try {

            firstNumber = theGui.getFirstNumber();
            operator = theGui.getOperator();
            secondNumber = theGui.getSecondNumber();

            theCalcModel.calculate(firstNumber, secondNumber, operator);

            theGui.setCalcSolution(theCalcModel.getCalcValue());

        }

        catch (NumberFormatException ex) {

            System.out.println(ex);

            theGui.displayErrorMessage("You Need to Enter 2 Numbers");

        }
    }
}

class SqrtCalcListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {

        double number = 0;

        try {

            number = theGui.getSqrtNumber();

            theSqrtCalcModel.sqrt(number);

            theGui.setSqrtCalcSolution(theSqrtCalcModel.getSqrtCalcValue());

        }

        catch (NumberFormatException ex) {
            System.out.println(ex);

            theGui.displayErrorMessage("You Need to enter a Number");
        }
    }
}

class QuadraticCalcListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {

        double a, b, c = 0;

        try {

            a = theGui.getQuadraticFirstNumber();
            b = theGui.getQuadraticSecondNumber();
            c = theGui.getQuadraticThirdNumber();

            theQuadraticCalcModel.quadraticFormula(a, b, c);

            theGui.setFirstQuadraticCalcSolution(theQuadraticCalcModel
                    .getFirstQuadraticValue());

            theGui.setSecondQuadraticCalcSolution(theQuadraticCalcModel
                    .getSecondQuadraticValue());

        }

        catch (NumberFormatException ex) {

            System.out.println(ex);

            theGui.displayErrorMessage("You need to enter 3 numbers.");
        }

    }
}

}