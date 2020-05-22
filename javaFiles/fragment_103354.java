FileInputStream fis = new FileInputStream("<NAME OF FILE.JASPER>"); 
BufferedInputStream bufferedInputStream = new BufferedInputStream(fis);
//Load bufferedInputStream file.jasper 
jasperReport = (JasperReport) JRLoader.loadObject(bufferedInputStream); 
jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,new JRBeanArrayDataSource(arrlist));
JasperExportManager.exportReportToPdfFile(jasperPrint,"<NAME OF OUTPUT FILE>");