public class ScannerIterable implements Iterable<String> {

    private Scanner scanner;

    public ScanerIterable(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Iterator<String> iterator() {
        return scanner;
    }
}