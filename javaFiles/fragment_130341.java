try (CSVReader reader = new CSVReader(new BufferedReader(
          new FileReader(pathToCSVFile)));) {

    List<String[]> lines = reader.readAll();
    return lines.toArray(new String[lines.size()][]);
}