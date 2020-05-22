try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {

    writer.write('\ufeff');

    CSVPrinter csvPrinter = new CSVPrinter(writer);

    //...
}