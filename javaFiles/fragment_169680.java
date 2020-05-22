import java.awt.Dimension;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class LinkedListCalculator {

static List<String> CalcInput = new LinkedList<String>();
static String operation = "1+2";
static int equationLength = operation.length();
static int result = 0;
static int num = 0;
static int mul = 1;
static int finalNum = 0;
static char lastOperator = 0;


public static void addToList() {
    String finalNumString;
    if (lastOperator == '+') {
        finalNumString = Integer.toString(finalNum);
        CalcInput.add(finalNumString);
        CalcInput.add("+");
    } else if (lastOperator == '-') {
        finalNumString = Integer.toString(finalNum);
        CalcInput.add(finalNumString);
        CalcInput.add("-");
    } else if (lastOperator == '*') {
        finalNumString = Integer.toString(finalNum);
        CalcInput.add(finalNumString);
        CalcInput.add("*");
    } else if (lastOperator == '/') {
        finalNumString = Integer.toString(finalNum);
        CalcInput.add(finalNumString);
        CalcInput.add("/");
    }
}

public static void computeList() {
    int size = CalcInput.size();
    String lastIndex = null;
    for (int i = 0; i < size; i++) {
        String currentIndex = CalcInput.get(i);
            if (i > 0) {
                lastIndex = CalcInput.get(i - 1);
            }

            if (currentIndex == "+") {
                int lastIndexInt = Integer.valueOf(lastIndex);
                result += lastIndexInt;
            }
            if (currentIndex == "-") {
                int lastIndexInt = Integer.valueOf(lastIndex);
                result -= lastIndexInt;
            }
            if (currentIndex == "*") {
                int lastIndexInt = Integer.valueOf(lastIndex);
                result *= lastIndexInt;
            }
            if (currentIndex == "/") {
                int lastIndexInt = Integer.valueOf(lastIndex);
                result /= lastIndexInt;
            }
    }

}

public static void main(String [] args) {



    for (int currEqnCharNdx = 0; currEqnCharNdx < equationLength ; currEqnCharNdx++) {
        char j = operation.charAt(currEqnCharNdx);

        if (j >= '0' && j <= '9') {
            num = j - '0';
            finalNum *= mul;
            finalNum += num;
            mul = 10;
        } else if (operation.charAt(currEqnCharNdx) == '+') {

            lastOperator = '+';
            addToList();
            mul = 1;
            finalNum = 0;
        } else if (operation.charAt(currEqnCharNdx) == '-') {
            addToList();
            lastOperator = '-';
            mul = 1;
            finalNum = 0;
        } else if (operation.charAt(currEqnCharNdx) == '*') {
            addToList();
            lastOperator = '*';
            mul = 1;
            finalNum = 0;
        } else if (operation.charAt(currEqnCharNdx) == '/') {
            addToList();
            lastOperator = '/';
            mul = 1;
            finalNum = 0;
        } 
    }
    int i = CalcInput.size();
    computeList();
    System.out.println("result: " + result);
}
}