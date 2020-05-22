File file = ResourceUtils.getFile("classpath:someFile");
InputStream inputStream = new FileInputStream(file);
Map map = anyMap();
GenericHandler genericHandler = service.readCsvData();        
Object actual = genericHandler.handle(inputStream, map);
// Add some assertions here