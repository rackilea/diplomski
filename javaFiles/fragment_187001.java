//Preparing data - change this as per your requirement
List<DataDTO> dataDTOList = new ArrayList<DataDTO>();
DataDTO dataDTO = new DataDTO; 
dataDTO.setFirstName("FirstName"); // in your Jasper field name is 'firstName' as type String
dataDTO.setLastName("LastName"); // in your Jasper field name is 'lastName' as type String
dataDTOList.add(dataDTO);

// Adding data
JRDataSource jrdatasource = new JRBeanCollectionDataSource(dataDTOList);

// Exporting report
File jasperFile = new File("C:/YourReport.jasper"); // change this
JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new FileInputStream(jasperFile.getAbsolutePath()));             
Map parameters = new HashMap();
JRConcurrentSwapFile jrSwapFile = new JRConcurrentSwapFile("C:/PDFOutput/"),30,2);
JRSwapFileVirtualizer virtualizer = new JRSwapFileVirtualizer(2,jrSwapFile,true);
parameters.put(JRParameter.REPORT_VIRTUALIZER, virtualizer);
JasperPrint jpPrintObj = JasperFillManager.fillReport(jasperReport,parameters,jrdatasource);
JasperExportManager.exportReportToPdfFile(jpPrintObj,"C:/PDFOutput/");`