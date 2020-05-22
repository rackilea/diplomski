String input = "id1,14/09/2016,20,0\n" +
               "id2,14/09/2016,25,5\n" +
               "id1,15/09/2016,11,2\n" +
               "idN,16/09/2016,14,5\n";
Map<String, Value> data = new TreeMap<>();
try (CSVParser parser = CSVParser.parse(input, CSVFormat.DEFAULT)) {
    for (CSVRecord record : parser) {
        String id = record.get(0);
        double maxTemp = Double.parseDouble(record.get(2));
        double minTemp = Double.parseDouble(record.get(3));
        Value value = data.get(id);
        if (value == null)
            data.put(id, new Value(maxTemp, minTemp));
        else
            value.add(maxTemp, minTemp);
    }
}
NumberFormat format = NumberFormat.getNumberInstance();
try (CSVPrinter printer = new CSVPrinter(System.out, CSVFormat.DEFAULT)) {
    for (Entry<String, Value> entry : data.entrySet()) {
        Value value = entry.getValue();
        printer.printRecord(entry.getKey(),
                            format.format(value.getAverageMaxTemp()),
                            format.format(value.getAverageMinTemp()));
    }
}