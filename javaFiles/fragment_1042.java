public class CellularData {

    private Object[][] array;
    private final int year;
    private int countryNum = 0;  // number of countries in array

    public CellularData(int rows, int columns, int year) {
        array = new Object[rows + 1][columns + 1];
        array[0][0] = "Country";
        this.year = year;
        for (int i = 1; i <= columns; i++) {
            array[0][i] = year++;
        }
        countryNum = 1;
    }