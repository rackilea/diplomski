CSVReader csvReader = new CSVReader(new FileReader(csvFile));
  ColumnPositionMappingStrategy<Car> strategy = new ColumnPositionMappingStrategy<Car>();
  strategy.setType(Car.class);
  String[] columns = new String[] {"CarManufacturer","Model","Color","Owner","MPG","LicensePlate","CountryOfOrigin","VIN"}; // the fields to bind do in your JavaBean
  strategy.setColumnMapping(columns);

  CsvToBean<Car> csv = new CsvToBean<Car>();
  List<Car> list = csv.parse(strategy, csvReader);