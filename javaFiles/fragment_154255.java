import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class SerialCheck {

  private static String leftPadWithX(String shortStr) {
    StringBuilder paddableString = new StringBuilder(shortStr);
    for (int i = 14 - shortStr.length(); i > 0; --i) {
      paddableString.insert(0, 'X');
    }
    assert paddableString.length() == 14;
    return paddableString.toString();
  }

  private static String fix(String broken) {
    assert broken.length() == 14;
    StringBuilder mutableBroken = new StringBuilder(broken);
    for(int i = 0; i < 14; ++i) {
      // not exactly a char, but need a 1 element string for regex matching
      String brokenChar = "" + mutableBroken.charAt(i);
      if (i < 2 && !Pattern.matches("\\d", brokenChar)) {
        mutableBroken.replace(i, i+1, "0");
      } else if (i == 2 && !Pattern.matches("-", brokenChar)) {
        mutableBroken.replace(i, i+1, "-");
      } else if (i > 2 && i < 7 && !Pattern.matches("\\d", brokenChar)) {
        mutableBroken.replace(i, i+1, "0");
      } else if (i == 7 && !Pattern.matches("\\.", brokenChar)) {
        mutableBroken.replace(i, i+1, ".");
      } else if (i > 7 && i < 12 && !Pattern.matches("\\d", brokenChar)) {
        mutableBroken.replace(i, i+1, "0");
      } else if (i >= 12 && i < 14 && !Pattern.matches("[abc\\d]", brokenChar)) {
        mutableBroken.replace(i, i+1, "0");
      }
    }
    return mutableBroken.toString();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("How many serial numbers would you like to check: ");
    int length = sc.nextInt();
    int valid = 0;

    String[] sSerials = new String[length];

    for (int nCtr = 0; nCtr < length; nCtr++) {
      System.out.print("Enter Serial " + (nCtr + 1) + ": ");
      sSerials[nCtr] = sc.next();
    }

    System.out.println();
    System.out.println("The following were added: ");
    for (int nCtr = 0; nCtr < length; nCtr++) {
      System.out.println(sSerials[nCtr]);
    }

    System.out.println();
    System.out.println("Comments\t" + "New Code");
    for (int nCtr = 0; nCtr < length; nCtr++) {
      boolean isValid = sSerials[nCtr].matches("[0-9]{2}-[0-9]{4}\\.[0-9]{4}[abc0-9]{2}");
    if (isValid) {
      System.out.println("Valid\t\t" + sSerials[nCtr]);
    } else if (sSerials[nCtr].length() > 14) {
      // if too long, create all padded zeros
      System.out.println("Invalid\tToo long\t00-0000.000000");
    } else if (sSerials[nCtr].length() < 14) {
      // too short, pad with 0s unconditionally and fix format
      String xPadded = leftPadWithX(sSerials[nCtr]);
      String fixed = fix(xPadded);
      System.out.println("Invalid\tToo short\t" + fixed);
    } else {
      // right length but bad format
      String fixed = fix(sSerials[nCtr]);
      System.out.println("Invalid\tBad format\t" + fixed);
      }
    }
  }
}