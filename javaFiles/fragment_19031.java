import java.util.Scanner;

public class ScannerTest {

    private Scanner consoleScanner;

    public ScannerTest() {
        consoleScanner = new Scanner(System.in);
    }

    @SuppressWarnings("unchecked")
    public <T extends Number> T readNumber(String description) {
        System.out.println(description);
        Number result = null;

        while (result == null) {
            System.out.print("\nChoose one: ");
            String textRead = consoleScanner.next();

            try {
                result = new Integer(textRead);
            } catch(Exception e1) {
                try {
                    result = new Long(textRead);
                } catch (Exception e2) {
                    try {
                        result = new Double(textRead);
                    } catch (Exception e3) {
                    }
                }
            }
            consoleScanner.nextLine();
        }

        return (T) result;
    }

    public static void main(String[] args) {
        ScannerTest t = new ScannerTest();
        for (int i = 0; i < 3; i++) {
            Number input = t.readNumber(i + ": Reading int, long or double...");
            System.out.println("Input class: " + input.getClass().getCanonicalName());
            System.out.println("Input value: " + input);
        }
    }  
}