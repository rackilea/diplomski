import java.util.Scanner;

public class ScannerTest {

    private Scanner consoleScanner;

    public ScannerTest() {
        consoleScanner = new Scanner(System.in);
    }

    @SuppressWarnings("unchecked")    
    private <T extends Number> T readType(String description, Class<T> desiredType) {
        System.out.println(description);
        Number result = null;

        while (result == null) {
            System.out.println();
            System.out.print("Choose one: ");
            try {
                if (Integer.class.equals(desiredType)) {
                    result = new Integer(consoleScanner.nextInt());
                } else if (Long.class.equals(desiredType)) {
                    result = new Long(consoleScanner.nextLong());
                }
            } catch(Exception e) {
                consoleScanner.nextLine();
            }
        }

        consoleScanner.nextLine();
        return (T) result;
    }

    public long readLong(String description) {
        return this.readType(description, Long.class);
    }

    public int readInt(String description) {
        return this.readType(description, Integer.class);
    }

    public static void main(String[] args) {
        ScannerTest t = new ScannerTest();
        t.readLong("Reading a long value...");
        t.readInt("Reading an integer value...");
    }  
}