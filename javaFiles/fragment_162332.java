public class CSVReader implements Iterable<CSVRow> {

    private List<String> _data;
    private int _itPos = 0;
    private int _skip = 0;
    private FileIterator _it;
    private boolean _hasTrailingComma = false;

    public CSVReader(Path path, boolean hasTrailingComma) throws IOException {
        this(Files.readAllLines(path), hasTrailingComma);
    }

    public CSVReader(Path path) throws IOException {
        this(path, false);
    }

    public CSVReader(List<String> data, boolean hasTrailingComma) {
        _data = data;
        _it = new FileIterator();
        _hasTrailingComma = hasTrailingComma;
    }

    public CSVReader(List<String> data) {
        this(data, false);
    }

    public CSVRow getHeaders() {
        return new CSVRow(_data.get(0), _hasTrailingComma);
    }

    public void skip(int rows) {
        _skip = rows;
    }

    @Override
    public Iterator<CSVRow> iterator() {
        _itPos = _skip;
        return _it;
    }

    private class FileIterator implements Iterator<CSVRow> {

        @Override
        public boolean hasNext() {
            return _itPos < _data.size();
        }

        @Override
        public CSVRow next() {
            if (_itPos == _data.size()) {
                throw new NoSuchElementException();
            }
            return new CSVRow(_data.get(_itPos++), _hasTrailingComma);
        }

    }
}