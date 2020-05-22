public class CSVRow implements Iterable<String> {

    private String[] _data;
    private int _itPos = 0;
    private int _skip = 0;
    private RowIterator _it = null;
    private int _actualLength = 0;

    public CSVRow(String row, boolean trailingComma) {
        // Minor hack
        // in case the data doesn't end in commas
        // we check for the last character and add
        // a comma. Ideally, the input file should be fixed;
        if(trailingComma && !row.endsWith(",")) {
            row += ",";
        }
        _data = row.split("\\s*,\\s*", -1);
        _actualLength = trailingComma ? _data.length - 1 : _data.length;
        _it = new RowIterator();
    }

    public CSVRow(String row) {
        this(row, false);
    }

    public void skip(int cells) {
        _skip = cells;
    }

    @Override
    public Iterator<String> iterator() {
        _itPos = _skip;
        return _it;
    }

    public String[] toArray() {
        return Arrays.copyOf(_data, _actualLength);
    }

    private class RowIterator implements Iterator<String> {

        @Override
        public boolean hasNext() {
            return _itPos < _actualLength;
        }

        @Override
        public String next() {
            if (_itPos == _actualLength) {
                throw new NoSuchElementException();
            }
            return _data[_itPos++];
        }

    }
}