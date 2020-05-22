import java.io.FileNotFoundException;

public class BugTester {

    public static void main(String[] args) throws FileNotFoundException {
        int start = 0;
        char bugSymbol = 'a';
        String inputFile = "peter.txt";
        Bug crawler1 = new Bug(start, bugSymbol, inputFile);
        crawler1.matrixBuilder();
        crawler1.matrixPrinter();
    }
}