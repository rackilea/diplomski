package com.Calculator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class QuadraticCalcModel {

private double firstQuadraticCalcValue;
private double secondQuadraticCalcValue;

public void quadraticFormula(double a, double b, double c) {

    double discriminant = (b * b) - (4 * a * c);

    if (discriminant >= 0) {

        firstQuadraticCalcValue = (Math.sqrt((b * b) - (4 * a * c)) + (-b))
                / (2 * a);

        secondQuadraticCalcValue = (Math.sqrt((b * b) - (4 * a * c)) - (-b))
                / (2 * a);

    }

    else {

        JFrame parent = new JFrame();
        JOptionPane.showMessageDialog(parent,
                "This function has no real roots.");

    }

}

public double getFirstQuadraticValue() {

    return firstQuadraticCalcValue;

}

public double getSecondQuadraticValue() {

    return secondQuadraticCalcValue;

}

}