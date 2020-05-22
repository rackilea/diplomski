BeanListProcessor<SUREDataBean> rowProcessor = new BeanListProcessor<SUREDataBean>(SUREDataBean.class);

CsvParserSettings parserSettings = new CsvParserSettings();
settings.getFormat().setDelimiter('|');
parserSettings.setRowProcessor(rowProcessor);
parserSettings.setHeaderExtractionEnabled(true);

CsvParser parser = new CsvParser(parserSettings);

//Parsing is started here.
//this submits all rows parsed from the input to the BeanListProcessor
parser.parse(new FileReader(new File("/examples/bean_test.csv"))); 

List<SUREDataBean> beans = rowProcessor.getBeans();