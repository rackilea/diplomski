CategoryDataset dataset = createDataset();
for (int r = 0; r < dataset.getRowCount(); r++) {
    double max = Double.MIN_VALUE;
    for (int c = 0; c < dataset.getColumnCount(); c++) {
        Number number = dataset.getValue(r, c);
        double value = number == null ? Double.NaN : number.doubleValue();
        if (value > max) {
            max = value;
        }
    }
    System.out.println(dataset.getRowKey(r) + ": " + max);
}