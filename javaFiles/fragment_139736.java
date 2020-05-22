//Create the design
JasperDesign design = new JasperDesign();
design.setWhenNoDataType(WhenNoDataTypeEnum.ALL_SECTIONS_NO_DETAIL); //We will run with no data
design.setName("Html test");
//Add a title band
JRDesignBand title = new JRDesignBand();
title.setHeight(100);
design.setTitle(title);

//Create our component
HtmlComponent hc = new HtmlComponent();
JRDesignExpression expression = new JRDesignExpression();
expression.setText("\"<b>Hello</b> world\"");
hc.setHtmlContentExpression(expression);

//Wrap it in a design componenent
JRDesignComponentElement ce = new JRDesignComponentElement(design);
ce.setComponentKey(new ComponentKey("http://jasperreports.sourceforge.net/htmlcomponent", "hc", "html"));
ce.setComponent(hc);
ce.setHeight(100);
ce.setWidth(100);
title.addElement(ce);

//Compile the design
JasperReport report = JasperCompileManager.compileReport(design);

//Generate the print (passing no datasource, empty)
JasperPrint print = JasperFillManager.fillReport(report, new HashMap<String,Object>());

//Export to pdf
JRPdfExporter exporter = new JRPdfExporter(); 
exporter.setExporterInput(new SimpleExporterInput(print));
exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("pdf/htmlComponent.pdf"));
SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
exporter.setConfiguration(configuration);
exporter.exportReport();