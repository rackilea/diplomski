public class NumberTest {

    public static void main(String[] args) {
        personalIdValidator("");
        personalIdValidator("0");
        personalIdValidator("1");
        personalIdValidator("123");
        personalIdValidator("-123");
        personalIdValidator("--123");
        personalIdValidator("abc");
        personalIdValidator("1a2b3c");
        personalIdValidator("‎٤‎٥‎٦‎٧‎٨‎");
    }

    public static void personalIdValidator(String personalIdNo) {
        if (personalIdNo.matches("-?[0-9]+")) {
            System.out.println("The input is only int");
        } else {
            System.out.println("The input is not only int");
        }
    }
}

// The input is not only int
// The input is only int
// The input is only int
// The input is only int
// The input is only int
// The input is not only int
// The input is not only int
// The input is not only int
// The input is not only int