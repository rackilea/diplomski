FileSet fs = new FileSet();
fs.setDir(new File(".."));
fs.createInclude().setName("TEST-*.xml");

XMLResultAggregator aggregator = new XMLResultAggregator();
aggregator.addFileSet(fs);
AggregateTransformer transformer = aggregator.createReport();
transformer.setFormat(Format.FRAMES);
transformer.setTodir(new File("..");