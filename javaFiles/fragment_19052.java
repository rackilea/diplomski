FileReader fr = new FileReader(f);
BufferedReader reader = new BufferedReader(fr);
String className = reader.readLine();

//Java reflection to get the Class Object.
Class<?> beanClass = Class.forName(className);

ValueProcessorProvider provider = new ValueProcessorProvider();
CSVEntryParser<?> entryParser = new AnnotationEntryParser<>(beanClass, provider); 
CSVReader<?> csvPersonReader = new CSVReaderBuilder<>(reader).entryParser(entryParser).build(); 

List<?> beanClassList = csvPersonReader.readAll();

System.out.println("First line: " + className);

return "";