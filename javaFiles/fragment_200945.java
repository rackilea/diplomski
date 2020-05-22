package com.Calculator;

public class MVCCalculator {

public static void main(String[] args) {

    CalcGui theGui = new CalcGui();

    CalcModel theCalcModel = new CalcModel();

    SqrtCalcModel theSqrtCalcModel = new SqrtCalcModel();

    QuadraticCalcModel theQuadraticCalcModel = new QuadraticCalcModel();

    new CalculatorController(theGui, theCalcModel, theSqrtCalcModel,
            theQuadraticCalcModel);

    theGui.setVisible(true);

}
}