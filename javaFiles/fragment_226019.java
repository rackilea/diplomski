String eqn = "7 + 13 = 20";

int operatorIndex = eqn.indexOf(operator); // already defined operator as a String
int equalIndex = eqn.indexOf('=');

int first = Integer.parseInt(eqn.substring(0, operatorIndex).trim());
int second = Integer.parseInt(eqn.substring(operatorIndex + 1, equalIndex).trim());