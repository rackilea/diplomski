public class CSVDataProvider {

    public Collection<Object[]> getData() throws FileNotFoundException {
        CSVReader reader = new CSVReader(new File("C:\\Users\\xxxxxxxxxxx\\Desktop\\TestData.csv"));
        int rowCount = reader.getRowCount();
        Object[][] data = new Object[rowCount][2];

        for (int i = 0; i < rowCount; i++) {
            Object[] singleRow = reader.getRow(i);
            data[i][0] = singleRow[0];
            data[i][1] = singleRow[1];
        }

        return Arrays.asList(data);
    }
}