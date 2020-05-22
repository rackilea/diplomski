FileReader fr = new FileReader(f);
BufferedReader reader = new BufferedReader(fr);
String className = reader.readLine();

//Java reflection to get the Class Object.
Class beanClass = Class.forName(className);

ValueProcessorProvider provider = new ValueProcessorProvider();
CSVEntryParser<beanClass> entryParser = new AnnotationEntryParser<beanClass>(beanClass.class, provider); // BeanClass, cannot find symbol
CSVReader<beanClass> csvPersonReader = new CSVReaderBuilder<beanClass>(reader).entryParser(entryParser).build(); // beanClass, cannot find symbol

List<beanClass> beanClassList = csvPersonReader.readAll(); // BeanClass, cannot find symbol

System.out.println("First line: " + className);

return "";