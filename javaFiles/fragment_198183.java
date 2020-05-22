String string = "1+5*2-4";

String[] operator = a.split("[0-9]+");
String[] digits = a.split("[+-\\/*]");

int reduced = Integer.parseInt(digits[0]);
for (int i = 1; i < digits.length; i++) {
    if (operator[i].equals("+")) { reduced += Integer.parseInt(digits[i]); } 
    else if (operator[i].equals("/")) { reduced /= Integer.parseInt(digits[i]); } 
    else if (operator[i].equals("*")) { reduced *= Integer.parseInt(digits[i]); } 
    else if (operator[i].equals("-")) { reduced -= Integer.parseInt(digits[i]); }
}