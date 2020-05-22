import java.util.Scanner;

public class Apweek2 {

public static void main(String[] args) {
    Scanner userinput = new Scanner(System.in);
    System.out.print("enter a number to convert to roman numerals: ");
    int input = userinput.nextInt();

    String[] rv = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD",
            "D", "CM", "M" };
    int[] values_for_rv = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900,
            1000 };

    System.out.print("enter a roman numeral: ");
    String roman_numeral = userinput.next().toUpperCase();


    int sum = 0;

    if (roman_numeral.length() % 2 == 0) {

    } else {
        char odd_value = roman_numeral.charAt(roman_numeral.length() - 1);
        if (odd_value == 'I') {
            sum = sum + 1;
        }
        if (odd_value == 'V') {
            sum = sum + 5;
        }
        if (odd_value == 'X') {
            sum = sum + 10;
        }
        if (odd_value == 'L') {
            sum = sum + 50;
        }
        if (odd_value == 'C') {
            sum = sum + 100;
        }
        if (odd_value == 'D') {
            sum = sum + 500;
        }
        if (odd_value == 'M') {
            sum = sum + 1000;
        }
    }

    String two_spot = null;
    String last_value = null;
    for (int i = 1, j = 0; j < roman_numeral.length()
            && i < roman_numeral.length(); i++, j++) {

        last_value = roman_numeral.substring(j, i);

        char roman_noodles = roman_numeral.charAt(i);

        String roman_values = Character.toString(roman_noodles);

        two_spot = last_value + roman_values;

        if (two_spot.contains(rv[1])) {
            sum = sum + values_for_rv[1];
            i++;
            j++;
        }
        if (two_spot.contains(rv[3])) {
            sum = sum + values_for_rv[3];
            i++;
            j++;
        }
        if (two_spot.contains(rv[5])) {
            sum = sum + values_for_rv[5];
            i++;
            j++;
        }
        if (two_spot.contains(rv[7])) {
            sum = sum + values_for_rv[7];
            i++;
            j++;
        }
        if (two_spot.contains(rv[9])) {
            sum = sum + values_for_rv[9];
            i++;
            j++;
        }
        if (two_spot.contains(rv[11])) {
            sum = sum + values_for_rv[11];
            i++;
            j++;
        }

        if (!(two_spot.equals(rv[1])) && !(two_spot.equals(rv[3]))
                && !(two_spot.equals(rv[5])) && !(two_spot.equals(rv[7]))
                && !(two_spot.equals(rv[9])) && !(two_spot.equals(rv[11]))) {

            for (int k = 0; k < two_spot.length(); k++) {

                char raman_noodles = two_spot.charAt(k);

                if (raman_noodles == 'I') {
                    sum = sum + 1;
                }
                if (raman_noodles == 'V') {
                    sum = sum + 5;
                }
                if (raman_noodles == 'X') {
                    sum = sum + 10;
                }
                if (raman_noodles == 'L') {
                    sum = sum + 50;
                }
                if (raman_noodles == 'C') {
                    sum = sum + 100;
                }
                if (raman_noodles == 'D') {
                    sum = sum + 500;
                }
                if (raman_noodles == 'M') {
                    sum = sum + 1000;
                }

            }
            i++;
            j++;
        }

    }
    System.out.println("Converted roman numeral to number is: "+sum);

    String inputconversion = inputtoroman(input);

    System.out.print("Converted number is: " + inputconversion);
}

public static String inputtoroman(int x) {

    String s1 = "";
    String s2 = "";
    String s3 = "";
    String s4 = "";
    String s5 = "";
    String s6 = "";
    String s7 = "";
    String s8 = "";
    String s9 = "";
    String s10 = "";
    String s11 = "";
    String s12 = "";
    String s13 = "";

    while (x >= 1000) {
        s1 += "M";
        x -= 1000;
    }
    while (x >= 900) {
        s2 += "CM";
        x -= 900;
    }
    while (x >= 500) {
        s3 += "D";
        x -= 500;
    }
    while (x >= 400) {
        s4 += "CD";
        x -= 400;
    }
    while (x >= 100) {
        s5 += "C";
        x -= 100;
    }
    while (x >= 90) {
        s6 += "XC";
        x -= 90;
    }
    while (x >= 50) {
        s7 += "L";
        x -= 50;
    }
    while (x >= 40) {
        s8 += "XL";
        x -= 40;
    }
    while (x >= 10) {
        s9 += "X";
        x -= 10;
    }
    while (x >= 9) {
        s10 += "IX";
        x -= 9;
    }
    while (x >= 5) {
        s11 += "V";
        x -= 5;
    }
    while (x >= 4) {
        s12 += "IV";
        x -= 4;
    }
    while (x >= 1) {
        s13 += "I";
        x -= 1;
    }
    String combined = s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10
            + s11 + s12 + s13;
    return combined;

  }

}