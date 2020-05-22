import java.io.PrintStream;

public class CsvWriter {

private final PrintStream printStream;

public CsvWriter() {
    this.printStream = System.out;
}

public CsvWriter(PrintStream printStream) {
    this.printStream = printStream;
}
...