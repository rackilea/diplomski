String outputFile = savePath+".csv";
CSVPrinter csvFilePrinter = null;
CSVFormat csvFileFormat = CSVFormat.EXCEL.withHeader();
FileWriter fileWriter = new FileWriter(outputFile);
csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);

csvFilePrinter.printRecords(excelParser.getRecords());


fileWriter.flush();
fileWriter.close();
csvFilePrinter.close();