public class Lab5_Exceptions_Redo extends Exception {

public static void main(String[] args) throws FileNotFoundException {

    String file = "inputt.txt";
    String file1 = "outputt.txt";
    String file2 = "errorr.txt";

    PrintWriter errorr = new PrintWriter(file2);
    PrintStream ps = new PrintStream(file2);

    PrintWriter outputt = new PrintWriter(file1);
    Scanner scan = new Scanner(new File(file));
    while (scan.hasNext()) {
        try {
            String number = scan.nextLine();
            int num = Integer.parseInt(number);
            System.out.println(num);
            outputt.println(num);
        } catch (InputMismatchException e) {
            errorr.println("There was an input mismatch error.");
            errorr.println(e.getMessage());
            e.printStackTrace(ps);
        } catch (NoSuchElementException e) {
            errorr.println("There is no such element.");
            errorr.println(e.getMessage());
            e.printStackTrace(ps);
        } catch (UnsupportedOperationException e) {
            errorr.println("An unsupported operation occured.");
            errorr.println(e.getMessage());
            e.printStackTrace(ps);
        } catch (NumberFormatException e) {
            errorr.println("Number Format Exception.");
            errorr.println(e.getMessage());
            e.printStackTrace(ps);
        }
    }
    errorr.close();
    outputt.close();
    scan.close();
}
}