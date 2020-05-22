import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScanFile {
    private static ClassLoader loader = ScanFile.class.getClassLoader();

    private static interface LineProcessor {
        void process(String line);
    }

    private static interface Reader<T> {
        T read(String resource, String delimiter) throws IOException;
        void flush();
    }

    private abstract static class FileScanner<T> implements Reader<T> {
        private LineProcessor processor;
        public void setProcessor(LineProcessor processor) {
            this.processor = processor;
        }

        public T read(Scanner scan, String delimiter, boolean close) throws IOException {
            scan.useDelimiter(delimiter);
            while (scan.hasNext()) {
                processor.process(scan.next().trim());
            }
            if (close) {
                scan.close();
            }
            return null;
        }

        public T read(InputStream is, String delimiter, boolean close) throws IOException {
            T t = read(new Scanner(is), delimiter, true);
            if (close) {
                is.close();
            }
            return t;
        }

        public T read(String resource, String delimiter) throws IOException {
            return read(loader.getResourceAsStream("resources/" + resource), delimiter, true);
        }
    }

    public static class FileTokenizer extends FileScanner<List<String>> {
        private List<String> tokens;
        public List<String> getTokens() {
            return tokens;
        }
        public FileTokenizer() {
            super();
            tokens = new ArrayList<String>();
            setProcessor(new LineProcessor() {
                @Override
                public void process(String token) {
                    tokens.add(token);
                }
            });
        }
        public List<String> read(Scanner scan, String delimiter, boolean close) throws IOException {
            super.read(scan, delimiter, close);
            return tokens;
        }
        @Override
        public void flush() {
            tokens.clear();
        }
    }

    public static void main(String[] args) {
        try {
            FileTokenizer scanner = new FileTokenizer();
            List<String> items = scanner.read("foo.txt", "\\.[\r\n]+");

            for (int i = 0; i < items.size(); i++) {
                System.out.printf("Line #%d%n-------%n%n%s%n%n", i + 1, items.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}