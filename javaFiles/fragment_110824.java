Map<String, Stock> readStocks (ObjectInputStream ois) {
  // Read all
}

void writeStocks (ObjectOutputStream oos, Map<String, Stock> stocks) {
  // Write all
}

Map<String, Stock> stocks;
// Use try-with-resources (Java 7+) to make life easier;
// the OIS (and underlying FIS) are guaranteed to be closed
// after this block ends.
try (ObjectInputStream ois = new ObjectInputStream(
         new FileInputStream(file)) {
  stocks = readStocks(ois, stocks);
}

// Make changes to loaded data
// (i.e. in accordance with user-supplied input)
updateStockData(stocks);

try (ObjectOutputStream oos = new ObjectOutputStream(
         new FileOutputStream(file)) {
  writeStocks(oos, stocks);
}