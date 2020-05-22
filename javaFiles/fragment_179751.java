@FunctionalInterface
public interface ScannerGetter<T> {
    T apply() throws InputMismatchException;
}

public <T> T getValueFromScanner(ScannerGetter<T> getter, String type) {
    while(1) {
        try {
            return getter.apply();
        } catch (InputMismatchException e) {
            System.err.printf("Invalid input, try again! Expected %s.");
        }
    }
}