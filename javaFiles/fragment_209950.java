public class Joption {

    // declared outside so easier to be accessed by other methods in the class
    private static int x;

    // is the number passed into this method even?
    private static boolean isEven(int x) {
        if (x % 2 == 0) {
            return true;
        }
        return false;
    }

    // is the number passed into this method single?
    private static boolean isSingle(int x) {
        if (x >= 0 || x < 10) {
            return true;
        }
        return false;
    }

    // is the number passed in even AND single?
    // notice how the number passed in flows into the two methods you just created. Their returns help you determine if they are even AND single.
    private static void isEvenAndSingle(int x) {
        if (isEven(x) && isSingle(x)) {
            JOptionPane.showMessageDialog(null, x + "is Even and Single!");
        }
    }

    // same as above method but now it's checking to see if it's even and NOT single.
    private static void isEvenAndNotSingle(int x) {
        if (isEven(x) && !(isSingle(x))) {
            JOptionPane.showMessageDialog(null, x + "is Even but NOT single!");
        }
    }

    // your main running method
    // here you actually need to call the isEvenAndSingle() and isEvenAndNotSingle() methods with the retrieved x value from the JOptionPane so that you can actually print the appropriate messages in the responding JOptionPane
    public static void main(String[] args) {
        x = Integer.parseInt(JOptionPane.showInputDialog(null, "What is your favorite number?"));
        isEvenAndSingle(x);
        isEvenAndNotSingle(x);
    }

}