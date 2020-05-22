final Reader in = new FileReader("counties.csv");
final Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);

for (final CSVRecord record : records) { // Simply iterate over the records via foreach loop. All the parsing is handler for you
    String populationString = record.get(7); // Indexes are zero-based
    String populationString = record.get("population"); // Or, if your file has headers, you can just use them

    … // Do whatever you want with the population
}