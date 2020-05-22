int operand1 = Integer.parseInt(jtmp.getText());
int operand2 = Integer.parseInt(jCalc.getText());
String operator = jSymbol.getText()); 

String result = "";
if (operator.equals("*")) {
    result = String.valueOf(operand1 * operand2);
}
// todo other operators

jCalcKalkulator.setText(result);