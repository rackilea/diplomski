class Array2DColumnCharSequnce implements CharSequence {

    private int column;
    private String[][] array2d;
    private int endIndex;
    private int startIndex;

    public Array2DColumnCharSequnce(String[][] array2d, int column) {
        this(array2d, column, 0, array2d[column].length);
        this.array2d = array2d;
        this.column = column;
    }

    public Array2DColumnCharSequnce(String[][] array2d, int column,
            int startIndex, int endIndex) {
        this.array2d = array2d;
        this.column = column;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public int length() {
        return endIndex - startIndex;
    }

    public char charAt(int index) {
        String charString = array2d[column][startIndex + index];
        return charString.charAt(0);
    }

    public CharSequence subSequence(int start, int end) {
        Array2DColumnCharSequnce array2dColumnCharSequnce = new Array2DColumnCharSequnce(
                array2d, column, start, end);
        return array2dColumnCharSequnce;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this);
        return sb.toString();
    }
}