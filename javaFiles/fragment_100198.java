import java.util.*;

public class CharacterArray {
    public List<String> splitToChar(String s) {
        List<String> returnValue = new LinkedList<String>();
        char[] chars = s.toCharArray();
        System.out.println(chars);
        String currentNumber = "";
        for (char inputChar : chars) {
            if (Character.isDigit(inputChar) == true) {
                currentNumber += inputChar;
            } else if (inputChar == '.' ||
                    inputChar == '+' ||
                    inputChar == '-' ||
                    inputChar == '/' ||
                    inputChar == '*' ||
                    inputChar == '(' ||
                    inputChar == ')') {
                if (currentNumber.length() > 0){
                    returnValue.add(currentNumber);
                }
                currentNumber = "";
                returnValue.add(""+inputChar);
            }  else {
                System.out.println("Incorrect input symbol");
            }
        }
        if (currentNumber.length() > 0){
            returnValue.add(currentNumber);
        }
        return returnValue;
    }
}