package com.Calculator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcGui extends JFrame {

private static final long serialVersionUID = 1L;
private String[] operatorsList = { "+", "-", "*", "/", "^" };

// Row 1
private JTextField firstNumber = new JTextField(10);
private JComboBox<String> operator = new JComboBox<>(operatorsList);
private JTextField secondNumber = new JTextField(10);
private JButton calculateButton = new JButton("Calculate");
private JTextField calcSolution = new JTextField(20);

// Row 2
private JLabel sqrtSymbol = new JLabel("√");
private JTextField sqrtNumber = new JTextField(10);
private JButton sqrtCalcButton = new JButton("Calculate");
private JTextField sqrtCalcSolution = new JTextField(20);

// Row 3
private JLabel quadraticLabel1 = new JLabel("A = ");
private JTextField quadraticFirstNumber = new JTextField(5);
private JLabel quadraticLabel2 = new JLabel("B = ");
private JTextField quadraticSecondNumber = new JTextField(5);
private JLabel quadraticLabel3 = new JLabel("C = ");
private JTextField quadraticThirdNumber = new JTextField(5);
private JButton quadraticCalcButton = new JButton("Calculate");
private JLabel quadraticTextBefore = new JLabel("x =");
private JTextField firstQuadraticCalcSolution = new JTextField(3);
private JLabel quadraticTextMiddle = new JLabel("and x =");
private JTextField secondQuadraticCalcSolution = new JTextField(3);

CalcGui() {

    JPanel calcPanel = new JPanel(new BorderLayout());
    FlowLayout Default = new FlowLayout(FlowLayout.LEFT);
    JPanel row1 = new JPanel(Default);
    JPanel row2 = new JPanel(Default);
    JPanel row3 = new JPanel(Default);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(650, 150);

    row1.add(firstNumber);
    row1.add(operator);
    row1.add(secondNumber);
    row1.add(calculateButton);
    row1.add(calcSolution);

    row2.add(sqrtSymbol);
    row2.add(sqrtNumber);
    row2.add(sqrtCalcButton);
    row2.add(sqrtCalcSolution);

    row3.add(quadraticLabel1);
    row3.add(quadraticFirstNumber);
    row3.add(quadraticLabel2);
    row3.add(quadraticSecondNumber);
    row3.add(quadraticLabel3);
    row3.add(quadraticThirdNumber);
    row3.add(quadraticCalcButton);
    row3.add(quadraticTextBefore);
    row3.add(firstQuadraticCalcSolution);
    row3.add(quadraticTextMiddle);
    row3.add(secondQuadraticCalcSolution);

    calcPanel.add(row1, BorderLayout.NORTH);
    calcPanel.add(row2, BorderLayout.CENTER);
    calcPanel.add(row3, BorderLayout.SOUTH);
    this.add(calcPanel);

}

// basic calculations methods
public double getFirstNumber() {

    return Double.parseDouble(firstNumber.getText());

}

public String getOperator() {

    return (String) operator.getSelectedItem();

}

public double getSecondNumber() {

    return Double.parseDouble(secondNumber.getText());

}

public void setCalcSolution(double solution) {

    calcSolution.setText(Double.toString(solution));

}

void addCalculateListener(ActionListener listenForCalcButton) {

    calculateButton.addActionListener(listenForCalcButton);

}

void displayErrorMessage(String errorMessage) {

    JOptionPane.showMessageDialog(this, errorMessage);

}

// Square root function methods
public double getSqrtNumber() {

    return Double.parseDouble(sqrtNumber.getText());

}

public void setSqrtCalcSolution(double solution) {

    sqrtCalcSolution.setText(Double.toString(solution));

}

void addSqrtCalcListener(ActionListener listenForSqrtCalcButton) {

    sqrtCalcButton.addActionListener(listenForSqrtCalcButton);

}

// Quadratic formula Methods
public double getQuadraticFirstNumber() {

    return Double.parseDouble(quadraticFirstNumber.getText());

}

public double getQuadraticSecondNumber() {

    return Double.parseDouble(quadraticSecondNumber.getText());

}

public double getQuadraticThirdNumber() {

    return Double.parseDouble(quadraticThirdNumber.getText());

}

public void setFirstQuadraticCalcSolution(double solution) {

    firstQuadraticCalcSolution.setText(Double.toString(solution));

}

public void setSecondQuadraticCalcSolution(double solution) {

    secondQuadraticCalcSolution.setText(Double.toString(solution));

}

void addQuadraticCalcListener(ActionListener listenForQuadraticCalcButton) {

    quadraticCalcButton.addActionListener(listenForQuadraticCalcButton);

}
}