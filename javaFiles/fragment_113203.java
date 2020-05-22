TaskOperationsImpl ops = new TaskOperationsImpl();
String output = (String) ops.getOutput(new URI(taskIdString), null);
DocumentBuilderFactory dfactory = DocumentBuilderFactory.newInstance();
dfactory.setNamespaceAware(true);
DocumentBuilder docBuilder = dfactory.newDocumentBuilder();
Node xmldoc = docBuilder.parse(new ByteArrayInputStream(output.getBytes()));